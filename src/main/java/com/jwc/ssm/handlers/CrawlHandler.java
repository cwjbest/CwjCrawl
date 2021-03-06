package com.jwc.ssm.handlers;

import com.jwc.ssm.entities.Crawl;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.DefaultHttpParams;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by cwj on 18-7-3.
 *
 */

@Controller
public class CrawlHandler {

    private static AtomicInteger id = new AtomicInteger(0);

    private static CopyOnWriteArrayList<Crawl> crawlList = new CopyOnWriteArrayList<Crawl>();
    private static CopyOnWriteArrayList<String> codeList =
            readFileByLines(System.getProperty("user.dir") + "/codelist.txt");

    private static CopyOnWriteArrayList<String> readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        CopyOnWriteArrayList<String> codeList = new CopyOnWriteArrayList<String>();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                codeList.add(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
            return codeList;
        }
    }

    // 网络请求并且html
    private static List<Crawl> doCatch(String site) {
        String siteRoot = "https://etherscan.io/token/generic-tokentxns2?contractAddress=" +
                "0x86fa049857e0209aa7d9e616f7eb3b3b78ecfdb0&a=";
        GetMethod method = new GetMethod(siteRoot + site);
        HttpClient client = new HttpClient();
        DefaultHttpParams.getDefaultParams().setParameter("http.protocol.cookie-policy",
                CookiePolicy.BROWSER_COMPATIBILITY);

        try {
            method.addRequestHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            method.addRequestHeader("Accept-Language", "zh-CN,zh;q=0.8");
            method.addRequestHeader("Avail-Dictionary", "XprLfaXG");
            method.addRequestHeader("Cache-Control", "max-age=0");
            method.addRequestHeader("Connection", "keep-alive");
            method.addRequestHeader("Cookie", "");
            method.addRequestHeader("Host", "user.qzone.qq.com");
            method.addRequestHeader("If-Modified-Since", "Wed, 24 Sep 2018 09:55:30 GMT");
            method.addRequestHeader("Upgrade-Insecure-Requests", "1");
            method.addRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.99 Safari/537.36ozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.99 Safari/537.36");

            client.executeMethod(method);
            InputStream htmlCode = method.getResponseBodyAsStream();

            // 得到所有的标签的链接
            Document doc = Jsoup.parse(htmlCode, "UTF-8", "");
            Elements elements = doc.select(".table tr");
            List<Crawl> list = new ArrayList<Crawl>();
            //每个url取5条
            for (int i = 1; i <= 5; i++) {
                Crawl crawl = new Crawl();
                crawl.setId(id.addAndGet(1));
                crawl.setUrl(site);
                crawl.setTxHash(elements.get(i).select("td").get(0).text());
                crawl.setAge(elements.get(i).select("td span").get(1).attr("title"));
                crawl.setFrom(elements.get(i).select("td").get(2).text());
                crawl.setIn_or_out(elements.get(i).select("td").get(3).text());
                crawl.setTo(elements.get(i).select("td").get(4).text());
                crawl.setQuantity(elements.get(i).select("td").get(5).text());
                list.add(crawl);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            method.abort();
            method.releaseConnection();
        }
        return null;
    }

    static class CounterThread extends Thread {
        private int count;
        private CountDownLatch latch;

        private CounterThread(int count, CountDownLatch latch) {
            this.count = count;
            this.latch = latch;
        }

        @Override
        public void run() {
            if (crawlList.size() >= codeList.size() * 5) {
                System.out.println(crawlList.size());
            } else {
                List<Crawl> list = doCatch(codeList.get(count));
                latch.countDown();
                if (list.size() == 5)
                    crawlList.addAll(list);
            }
            System.out.println(currentThread().getName() + " 完成");
        }
    }


    private static List multiThreadDoCatch(CountDownLatch latch) throws InterruptedException {
        int length = codeList.size();
        Thread[] threads = new Thread[length];
        for (int i = 0; i < length; i++) {
            threads[i] = new CounterThread(i, latch);
            threads[i].setName("MyThread-" + i);
            threads[i].start();
        }
        return crawlList;
    }

    @RequestMapping("/crawl")
    public String list(Map<String, Object> map) throws InterruptedException {
        int length = 10;
        CountDownLatch latch = new CountDownLatch(length);
        map.put("crawl", multiThreadDoCatch(latch));
        latch.await();
        return "crawl";
    }
}


