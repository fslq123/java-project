package com.fslq.day05.demoapi;

import java.util.Scanner;

public class ScannerAnonymous {
    public static void main(String[] args) {
        System.out.print("请输入：");
        methodShow(new Scanner(System.in));
    }
    public static void methodShow(Scanner scanner){
        System.out.println("输入数是："+scanner.nextInt());
    }
}
