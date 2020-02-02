package com.fslqup.day05.Concurrent;
/*
*并发：同一个时间段内发生
*
* */
public class ConcurrentMain {
    public static void main(String[] args) {
        Student stu1=new Student ("小张");
        stu1.run ();//线程
    }
}
