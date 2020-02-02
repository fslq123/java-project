package com.fslq.day04.demo2;

public class DemoMethod {
    public static void main(String[] args) {
        print();
    }
    public static void print(){
        for(int i=0;i<5;i++)
        {
            System.out.println();
            for (int j=0;j<5;j++)
                System.out.print("*");
        }

    }
}
