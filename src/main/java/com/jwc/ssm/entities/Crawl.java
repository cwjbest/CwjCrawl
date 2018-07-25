package com.jwc.ssm.entities;

import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by cwj on 18-7-3.
 *
 */
@Repository
public class Crawl {
    private int id;
    private String url;
    private String txHash;
    private Date age;
    private String from;
    private String in_or_out;
    private String to;
    private String quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    public String getAge() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(this.age);
    }

    public void setAge(String age) throws ParseException {
        DateFormat format = new SimpleDateFormat("MMM-dd-yyyy hh:mm:ss aa", Locale.ENGLISH);
        Date date = format.parse(age);
        this.age = date;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getIn_or_out() {
        return in_or_out;
    }

    public void setIn_or_out(String in_or_out) {
        this.in_or_out = in_or_out;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Crawl(int id, String url, String txHash, Date age, String from, String in_or_out, String to, String quantity) {
        this.id = id;
        this.url = url;
        this.txHash = txHash;
        this.age = age;
        this.from = from;
        this.in_or_out = in_or_out;
        this.to = to;
        this.quantity = quantity;
    }
    public Crawl(){}

    @Override
    public String toString() {
        return "Crawl{" +
                "id='" + id + '\'' +
                "url='" + url + '\'' +
                "txHash='" + txHash + '\'' +
                ", age='" + age + '\'' +
                ", from='" + from + '\'' +
                ", in_or_out='" + in_or_out + '\'' +
                ", to='" + to + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
