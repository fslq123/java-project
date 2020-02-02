package com.fslqup.day05.Concurrent;
/*
* 1.创建一个Thread类的子类
* 2.在Thread类的子类中重写Thread类中的run方法
* 3.创建Thread类的子类对象
* 4.调用Thread类中的方法start方法，开启新的线程，执行run方法
* */
public class DemoThread {
    public static void main(String[] args) {
        MyThread myThread=new MyThread ();
        myThread.start ();
        for (int i = 0; i <10; i++) {
            System.out.println ("第一Main: "+i);
        }
    }
}
