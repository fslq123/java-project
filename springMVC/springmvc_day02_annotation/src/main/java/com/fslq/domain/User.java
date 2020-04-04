package com.fslq.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String uname;
    private Integer uage;
    private Date birthday;

    @Override
    public String toString() {
        return "User{"+
                "uname='"+uname+'\''+
                ", uage="+uage+
                ", birthday="+birthday+
                '}';
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname=uname;
    }

    public Integer getUage() {
        return uage;
    }

    public void setUage(Integer uage) {
        this.uage=uage;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday=birthday;
    }

    public User(String uname,Integer uage,Date birthday) {
        this.uname=uname;
        this.uage=uage;
        this.birthday=birthday;
    }
}
