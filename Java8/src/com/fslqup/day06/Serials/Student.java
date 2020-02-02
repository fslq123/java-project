package com.fslqup.day06.Serials;

import java.io.Serializable;
//必须实现Serializable接口
public class Student implements Serializable {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age=age;
    }

    public Student(String name,Integer age) {
        this.name=name;
        this.age=age;
    }
}
