package com.fslq.dao.impl;

import com.fslq.dao.AccountDao;

import java.lang.reflect.Array;
import java.util.*;

public class AccountDaoImpl implements AccountDao {

    //bean注入演示
    private String name;
    private Integer age;
    private Date birthday;

    //bean注入集合
    private Integer[] array;
    private List<String> list;
    private Map<Integer,String> map;



    public void showCollection(){
        System.out.print("array:[");
        Arrays.stream(array).forEach(i->System.out.print(i+" "));

        System.out.println("]\nlist:"+list);
        System.out.println("map"+map);
    }

    public Integer[] getArray() {
        return array;
    }

    public void setArray(Integer[] array) {
        this.array=array;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list=list;
    }

    public Map<Integer, String> getMap() {
        return map;
    }

    public void setMap(Map<Integer, String> map) {
        this.map=map;
    }

    public AccountDaoImpl(String name,Integer age,Date birthday) {
        this.name=name;
        this.age=age;
        this.birthday=birthday;
    }

    public void printAccountDao() {
        System.out.println("Dao账户："+name+age+birthday);
    }


    public AccountDaoImpl() {

    }

    public void saveAccountDao() {
        System.out.println("AccountDao对象保存了");
    }
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday=birthday;
    }
}
