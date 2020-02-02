package com.fslqup.day06.File;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Scanner;

public class DemoFile {
    public static void main(String[] args) throws IOException {

        //show();
       // show1();
        show2();
    }
    /*过滤器*/
    private static void show2() {
        System.out.print("输入路径名：");
        File file=new File(new Scanner(System.in).next());
        System.out.print("\n输入关键字：");
        String s=new Scanner(System.in).next();
        File[] files=file.listFiles((File f,String name)->{
            return new File(f,name).isDirectory()||name.toLowerCase().endsWith(".txt");
        });
        for (File file1 : files) {
                System.out.println(file1);
        }
    }


    private static void show1() {
        System.out.print("输入路径名：");
        File file=new File(new Scanner(System.in).next());
        System.out.print("\n输入关键字：");
        String s=new Scanner(System.in).next();
        File[] files=file.listFiles();
        for (File file1 : files) {
            if(file1.toString().contains(s))
                System.out.println(file1);
        }
    }

    private static void show() {
        File file=new File("C:\\Users\\22966\\Pictures");
        System.out.println(file.getName());
        System.out.println(file.getAbsoluteFile());
        //file.createNewFile();

        //遍历路径
        String[] list=file.list();
        for (String s:list
        ) {
            System.out.println(s);
        }
        File[] files=file.listFiles();
        for (File file1 : files) {
            System.out.println(file1);
        }
    }
}
