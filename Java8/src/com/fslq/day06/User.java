package com.fslq.day06;

public class User {
    private  String name;
    private Integer money;

    public User() {
    }

    public User(String name, Integer money) {
        this.name = name;
        this.money = money;
    }

    public  void show(){
        System.out.println("我叫:"+this.name+"，我有"+this.money+"钱");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
