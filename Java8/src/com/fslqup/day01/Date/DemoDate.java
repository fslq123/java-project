package com.fslqup.day01.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoDate {
    public static void main(String[] args) {
        System.out.println (new Date().toString ());
        dateFormat();
        dateParse();
    }

    private static void dateParse() {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat ("yyyy年MM月dd日 时间：HH:mm:ss");
        try {
            Date date=simpleDateFormat.parse ("2022年02月11日 时间：14:14:14");//反向解析
            System.out.println (date.toString ());
        } catch (ParseException e) {
            e.printStackTrace ();
        }
    }

    private static void dateFormat() {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat ("yyyy年MM月dd日 时间：HH:mm:ss");
        Date date=new Date ();
        String time=simpleDateFormat.format (date);
        System.out.println (time);
    }
}
