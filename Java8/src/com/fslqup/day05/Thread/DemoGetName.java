package com.fslqup.day05.Thread;

public class DemoGetName {
    public static void main(String[] args) {
        //创建Thread类的子类对象
        MyThread myThread=new MyThread ();
        //调用start方法，开启新线程，执行run方法
        myThread.start ();
        new MyThread ().start ();
        new MyThread ().start ();

        System.out.println ("主当前线程："+Thread.currentThread ().getName ());
    }
}
