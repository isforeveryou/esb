package com.forever.provider.dto;

/**
 * @author WJX
 * @date 2021/4/15 11:29
 */
public class Record {

    private String name;

    private Integer sales;

    private String leadSinger;

    private String publishTime;

    public Record(){}

    public Record(String name, Integer sales, String leadSinger, String publishTime){
        this.name = name; this.sales = sales; this.leadSinger = leadSinger; this.publishTime = publishTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getLeadSinger() {
        return leadSinger;
    }

    public void setLeadSinger(String leadSinger) {
        this.leadSinger = leadSinger;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    @Override
    public String toString() {
        return "Record{" +
                "name='" + name + '\'' +
                ", sales=" + sales +
                ", leadSinger='" + leadSinger + '\'' +
                ", publishTime='" + publishTime + '\'' +
                '}';
    }
}
