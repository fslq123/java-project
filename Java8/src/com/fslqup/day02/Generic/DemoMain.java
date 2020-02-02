package com.fslqup.day02.Generic;

import java.util.ArrayList;

/*
* 泛型通配符<?>:用于传递打印，不能用于存储*/
public class DemoMain {
    public static void main(String[] args) {
        GenericClass<String> genericClass=new GenericClass<> ("小明");
        System.out.println ("泛型类实现："+genericClass.getName ());
        genericClass.GenericMethod (genericClass.getName ());

        new GenericInterface<String> () {
            @Override
            public <I> void Show(I i) {
                System.out.println (i);
            }
        }.Show ("泛型接口匿名实现");

        //泛型通配符
        ArrayList<String> list1=new ArrayList<> ();
        list1.add ("你好哇");
        list1.add ("老朋友");

        ArrayList<Integer> list2=new ArrayList<> ();
        list1.add (String.valueOf (11));
        list1.add (String.valueOf (22));
        Show (list1);
        Show (list2);
    }

    public static void Show(ArrayList<?> i){
        for (Object arr:i
             ) {
            System.out.println (arr);
        }
    }
}
