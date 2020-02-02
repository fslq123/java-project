package com.fslqup.day06.IO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class ReaderAndWriter {
    public static void main(String[] args) throws IOException {
        writer();
        writerAppend();//续写
        reader();
        tryCatchIO();//JDK1.7特性
    }

    private static void tryCatchIO() {
        try(FileWriter fw=new FileWriter("C:\\Users\\22966\\Pictures\\b.txt");
            FileReader fr=new FileReader("C:\\Users\\22966\\Pictures\\b.txt");
            ){
            //写入内存
            fw.write("我是谁");
            //刷入磁盘:流可以继续使用
            fw.flush();
            //关闭流
            fw.close();
//********************************************
            char[] cb=new char[1024];
            fr.read(cb);
            for (char c : cb) {
                System.out.print(c);
            }
            fr.close();
        }catch ( IOException e ){
            e.getMessage();
        }
    }

    private static void writerAppend() throws IOException {
        FileWriter fw=new FileWriter("C:\\Users\\22966\\Pictures\\b.txt",true);
        //写入内存
        fw.write("你是\r\n我");
        //刷入磁盘:流可以继续使用
        fw.flush();
        //关闭流
        fw.close();

    }

    private static void writer() throws IOException {
        FileWriter fw=new FileWriter("C:\\Users\\22966\\Pictures\\b.txt");
        //写入内存
        fw.write("我是谁");
        //刷入磁盘:流可以继续使用
        fw.flush();
        //关闭流
        fw.close();

    }

    private static void reader() throws IOException {
        FileReader fr=new FileReader("C:\\Users\\22966\\Pictures\\b.txt");
        char[] cb=new char[1024];
        fr.read(cb);
        for (char c : cb) {
            System.out.print(c);
        }
        fr.close();
    }
}
