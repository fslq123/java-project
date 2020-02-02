package com.fslqup.day01.System;

public class DemoSystem {
    public static void main(String[] args) {
        demo_arraycopy();
    }

    private static void demo_arraycopy() {
        int[] src= {1, 2, 3, 4, 5};
        int[] desc={6,7,8,8,9,10};
        System.arraycopy (src,0,desc,0,3);
        for (Integer i:desc
             ) {
            System.out.print (" "+i);
        }
    }
}
