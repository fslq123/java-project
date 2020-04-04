package com.fslq.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String uname;
    private Integer age;
    private Date birthday;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname=uname;
    }

    @Override
    public String toString() {
        return "User{"+
                "uname='"+uname+'\''+
                ", age="+age+
                ", birthday="+birthday+
                '}';
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age=age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday=birthday;
    }

    public User() {
    }

    public User(String uname,Integer age,Date birthday) {
        this.uname=uname;
        this.age=age;
        this.birthday=birthday;
    }
}
