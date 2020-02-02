package com.fslq.day05.demostatic;

public class Student {
    private Integer id;
    private String name;
    private static String room;
    static int inCount=0;

    /*
    * 静态代码块：优先执行
    * 仅执行一次，用于对一次性对静态变量成员一次性赋值*/
    static {
        System.out.println("静态代码块！！！");
    }

    public Student(String name){
        this.id=inCount++;
        this.name=name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getRoom() {
        return room;
    }

    public static void setRoom(String room) {
        Student.room = room;
    }
}
