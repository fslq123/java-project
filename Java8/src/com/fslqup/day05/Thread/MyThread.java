package com.fslqup.day05.Thread;

public class MyThread extends Thread {
    @Override
    public void run() {
        //获取线程名称
        String name=getName ();
        System.out.println ("线程名称："+name );
        System.out.println ("当前线程："+Thread.currentThread ().getName ());
    }
}
