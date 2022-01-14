package com.dipanjal.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    private String chair = "Red Chair";
    protected String bed = "King Size Bed";
    private Date nowDate;

    String table = "Dining Table";

    public String getNowDate() {
        if(nowDate == null)
            this.nowDate = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return simpleDateFormat.format(this.nowDate);
    }

    public void setNowDate(Date nowDate) {
        this.nowDate = nowDate;
    }

    public String getChair() {
        return "Dining: "+chair;
    }

    public void setChair(String chair) {
        this.chair = chair;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }
}
