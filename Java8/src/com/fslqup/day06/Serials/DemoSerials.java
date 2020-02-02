package com.fslqup.day06.Serials;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
* 自定义类存储于本地文件中
* */
public class DemoSerials{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //1.定义类对象集合
        Student one=new Student("张三",12);
        Student two=new Student("李四",14);
        Student three=new Student("王五",18);
        ArrayList<Student> arrayList=new ArrayList<>();
        Collections.addAll(arrayList,one,two,three);
        //2.序列化
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("C:\\Users\\22966\\Pictures\\serials.txt"));
        oos.writeObject(arrayList);
        //3.反序列化
         ObjectInputStream ois=new ObjectInputStream(new FileInputStream("C:\\Users\\22966\\Pictures\\serials.txt"));
         Object o=ois.readObject();
        //4.打印
        ArrayList<Student> arrayList1=new ArrayList<>();
        arrayList1=(ArrayList<Student>)o;
        for (Student student : arrayList1) {
            System.out.println(student.getName()+student.getAge());
        }
        //5.关闭流
        oos.close();
        ois.close();
    }
}
