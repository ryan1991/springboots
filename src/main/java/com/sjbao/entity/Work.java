package com.sjbao.entity;

/**
 * 工作经历
 * @Author ryan.song
 * @Date 2018/10/11
 **/
public class Work {
    private String year;
    private String location;
    public Work(){}

    public Work(String year, String location) {
        this.year = year;
        this.location = location;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
