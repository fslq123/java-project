package com.fslqup.day05.Thread;

public class RunnableImpl implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <3 ; i++) {
            System.out.println ("当前子线程："+Thread.currentThread ().getName ());
        }
    }
}
