package com.fslqup.day05.Concurrent;

public class Student {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run(){
        //定义循环，执行主方法的线程
        for (int i = 1; i <21 ; i++) {
            System.out.println (name+"-->"+i);
        }
    }

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }
}
