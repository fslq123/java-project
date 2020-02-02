package com.fslq.day05.demoapi;

import com.fslq.day05.demo1.Person;

/*Anonymous object only use once(just new)*/
public class DemoAnonymous {
    public static void main(String[] args) {
    Person one=new Person();
    one.name="我";
    one.show();

    //匿名对象
        new Person().name="你";
        new Person().show();

    }

}
