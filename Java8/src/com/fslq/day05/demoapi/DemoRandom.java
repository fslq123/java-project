package com.fslq.day05.demoapi;

import java.util.Random;

public class DemoRandom {
    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            System.out.println(new Random().nextInt(30));//0__29 Anonymous
        }
    }
}
