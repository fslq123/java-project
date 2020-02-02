package com.fslqup.day05.Thread;

public class DemoSetName {

    public static void main(String[] args) {
        //开启多线程
        MyThread myThread=new MyThread ();
        myThread.setName ("线程一");
        myThread.start ();
    }
}
