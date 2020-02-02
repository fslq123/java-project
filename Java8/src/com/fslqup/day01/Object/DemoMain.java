package com.fslqup.day01.Object;

import java.util.Objects;

public class DemoMain {
    public static void main(String[] args) {
        /*重写toString()*/
        Person person=new Person ("张三",25);
        String str=person.toString ();//默认为地址值，所以要重写
        System.out.println (str);

        /*重写equals()*/
        Person one=new Person ("张三",25);
        Person two=new Person ("张三",25);
        System.out.println (one.equals (two));

        /*null与str比较*/
        System.out.println (Objects.equals (null,"fuck"));
    }
}
