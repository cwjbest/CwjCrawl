# CwjCrawl 多线程java爬虫
爬虫本来python写是最简单的，但是同学要的有点儿紧，所以就用我最熟悉的java写了

### 整体流程
1. 从codelist文件中读取字符串，交给crawl类
2. 使用HttpClient做爬虫，用Jsoup解析dom树
3. 多线程取回数据，然后给前端

### 问题
1.用springMVC做逻辑控制，比如每次需要爬取50条数据，而springMVC的@RequestMapping("/xx")会立即返回，这样就会有个问题
  数据还没有全部爬完，主线程已经返回了，前端显示就会不足50条。解决方法很容易想到，让主线程等待爬虫子线程全部执行完毕之后在结束。
  使用join()太繁琐，根据当前活动线程数又不太精确，最后采用countDownLucth解决
  
  
