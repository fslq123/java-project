package com.fslq.day05.demostring;
/*
* split：正则表达式，英文“.”要反转义
* */
public class StringSplit {
    public static void main(String[] args) {
        String str1="你好，我是：‘你爸爸’！，Do you know.HaHa!!";


        String[] strarray1=str1.split("，");
        for (String str:strarray1
             ) {
            System.out.println(str);
        }
        System.out.println("=============");

        String[] strarray2=str1.split("\\.");
        for (String str:strarray2
        ) {
            System.out.println(str);
        }
    }


}
