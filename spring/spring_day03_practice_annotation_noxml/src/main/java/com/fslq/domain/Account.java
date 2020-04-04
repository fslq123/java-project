package com.fslq.domain;

import org.apache.commons.dbutils.ResultSetHandler;

/*
* 账户的实体类
* */
public class Account {
    private Integer id;
    private String name;
    private Float money;

    public Account() {
    }

    public Account(Integer id,String name,Float money) {
        this.id=id;
        this.name=name;
        this.money=money;
    }

    public Account(String name,float money) {
        this.name=name;
        this.money=money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id=id;
    }



    public void setName(String name) {
        this.name=name;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money=money;
    }

    @Override
    public String toString() {
        return "Account{"+
                "id="+id+
                ", name='"+name+'\''+
                ", money="+money+
                '}';
    }

    public String getName() {
        return name;
    }
}
