package com.fslq.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable {
    private Integer id;
    private String username;
    private String sex;
    private String address;
    private Date birthday;

    //一对多关系映射
    private List<Account> accountList;

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList=accountList;
    }

    public User() {
    }

    public User(Integer id,String username,String sex,String address,Date birthday) {
        this.id=id;
        this.username=username;
        this.sex=sex;
        this.address=address;
        this.birthday=birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                ", accountList=" + accountList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id=id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username=username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex=sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address=address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday=birthday;
    }
}
