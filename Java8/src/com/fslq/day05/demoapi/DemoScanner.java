package com.fslq.day05.demoapi;

import java.util.Scanner;

public class DemoScanner {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("请输入：");
        int sc=scanner.nextInt();
        System.out.println("数据："+sc);
    }
}
