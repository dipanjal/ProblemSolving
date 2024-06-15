package com.dipanjal.test;

import java.util.Date;

public class Visitor {

    private void someProcess(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Person p = new Person();
        System.out.println(p.getNowDate());
        Visitor v = new Visitor();
        v.someProcess();
        p.setNowDate(new Date());
        System.out.println(p.getNowDate());
    }
}
