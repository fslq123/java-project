package com.fslqup.day01.Calendar;

import java.util.Calendar;

public class DemoCalender {
    public static void main(String[] args) {
        demo1();
    }

    private static void demo1() {
       /* Calendar calendar=Calendar.getInstance ();
        System.out.println ("获取年："+calendar.get(Calendar.YEAR));
        calendar.set (Calendar.YEAR,2008);
        calendar.add (Calendar.YEAR,3);
        System.out.println ("获取年："+calendar.get(Calendar.YEAR));*/
        String str="10111";
        String str1="10010";
        char[] chars=str.toCharArray();
        char[] chars1=str1.toCharArray();
        String s=null;
        System.out.println(chars[1]);
        for (int i=chars.length-1; i >= 0; i--) {
            if(chars[i]==chars1[i]&&chars[i]=='1')

        }
    }
}
