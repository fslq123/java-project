package com.fslqup.day06.Character;

import java.io.*;
import java.nio.CharBuffer;

public class DemoStream {
    public static void main(String[] args) {
        String sre="C:\\Users\\22966\\Pictures\\UTF-8.txt";
        String des="C:\\Users\\22966\\Pictures\\GBK.txt";
        //读出&写入
        try(
                InputStreamReader isr=new InputStreamReader(new FileInputStream(sre),"UTF-8");
                OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream(des),"GBK");
        ){

            char[] cbuf=new char[10];
            isr.read(cbuf);
            System.out.println(cbuf);
            osw.write(cbuf);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
