package com.fslq.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Person implements Serializable {
    private String username;
    private String password;
    //集合
    private List<User> list;
    private Map<Integer,User> map;

    @Override
    public String toString() {
        return "Person{"+
                "username='"+username+'\''+
                ", password='"+password+'\''+
                ", list="+list+
                ", map="+map+
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username=username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password=password;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list=list;
    }

    public Map<Integer, User> getMap() {
        return map;
    }

    public void setMap(Map<Integer, User> map) {
        this.map=map;
    }
}
