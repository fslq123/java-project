package com.fslqup.day05.Concurrent;

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <20 ; i++) {
            System.out.println ("第二Run: "+i);
        }
    }
}
