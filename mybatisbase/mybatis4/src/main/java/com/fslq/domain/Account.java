package com.fslq.domain;

import java.io.Serializable;

public class Account implements Serializable {
    private Integer id;
    private Integer uid;
    private Double money;
    /*一对一关系映射*/
    private User user;//将User封装到Account中
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user=user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id=id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid=uid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money=money;
    }
}
