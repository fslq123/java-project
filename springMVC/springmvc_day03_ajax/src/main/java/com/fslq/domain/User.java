package com.fslq.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String uname;
    private Integer age;


    public User() {
    }

    public User(String uname,Integer age) {
        this.uname=uname;
        this.age=age;

    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname=uname;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{"+
                "uname='"+uname+'\''+
                ", age="+age+
                '}';
    }

    public void setAge(Integer age) {
        this.age=age;
    }

}
