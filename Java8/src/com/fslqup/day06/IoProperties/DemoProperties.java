package com.fslqup.day06.IoProperties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/*
* Properties:为与IO流结合使用的属性集合
* OutputStream不能写中文
* */
public class DemoProperties {
    public static void main(String[] args) throws IOException {
        show();
        show2();//文件写入属性
        show3();//读取

    }

    private static void show3() throws IOException {
        FileReader fr=new FileReader("C:\\Users\\22966\\Pictures\\prop.txt");
        Properties prop=new Properties();
        prop.load(fr);
        fr.close();
        Set<String> set=prop.stringPropertyNames();
        for (String s : set) {
            System.out.println(s+"-->"+prop.getProperty(s));
        }

    }

    private static void show2() throws IOException {
        Properties prop=new Properties();
        FileWriter fw =new FileWriter("C:\\Users\\22966\\Pictures\\prop.txt");
        prop.setProperty("姓名","身高");
        prop.setProperty("武大郎","160");
        prop.setProperty("西门庆","185");

        prop.store(fw,"Sava Data");
        fw.close();
    }

    private static void show() {
        Properties prop=new Properties();

        prop.setProperty("姓名","身高");
        prop.setProperty("武大郎","160");
        prop.setProperty("西门庆","185");

        //读取
        Set<String> set=prop.stringPropertyNames();
        for (String s : set) {
            System.out.println(s+" --> "+prop.getProperty(s));
        }
    }
}
