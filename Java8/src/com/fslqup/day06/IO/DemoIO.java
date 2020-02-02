package com.fslqup.day06.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DemoIO {
    public static void main(String[] args) throws IOException {
        outPut();//写入
        inPut();//读出
    }

    private static void inPut() throws IOException {
        FileInputStream fis=new FileInputStream("C:\\Users\\22966\\Pictures\\a.txt");
        byte[] bytes=fis.readAllBytes();
        System.out.println(new String(bytes));
        fis.close();
    }

    private static void outPut() throws IOException {
        FileOutputStream fos=new FileOutputStream("C:\\Users\\22966\\Pictures\\a.txt");
        byte[] bytes="ABCDEfg".getBytes();
        fos.write(bytes);
        fos.close();
    }
}
