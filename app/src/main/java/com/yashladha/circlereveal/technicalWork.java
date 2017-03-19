package com.yashladha.circlereveal;

public class technicalWork {
    private String type;
    private String Month;
    private String Date;

    public technicalWork(String type, String month, String date) {
        this.type = type;
        Month = month;
        Date = date;
    }

    public String getType() {
        return type;
    }

    public String getMonth() {
        return Month;
    }

    public String getDate() {
        return Date;
    }
}
