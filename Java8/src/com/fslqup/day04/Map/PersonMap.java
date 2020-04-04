package com.fslqup.day04.Map;

import com.fslqup.day01.Object.Person;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/*
Map:key为集合，自动排序
自定义类要重写equals和Hashcode方法，toString();
* */
public class PersonMap {
    public static void main(String[] args) {
        Map<String , Person> map=new HashMap<String,Person> ();
        Map< Person,String > map1=new HashMap<Person,String> ();
        LinkedList<Person> people=new LinkedList<> ();
        Collections.addAll (people,new Person ("张良",28),new Person ("黄忠",34),new Person ("诸葛亮",20),new Person ("诸葛亮",20));
        fun1(map,people);
        System.out.println("字典："+map);
        fun2 (map1,people);
    }

    private static void fun1(Map<String, Person> map, LinkedList<Person> people) {
        map.put ("英雄三",people.get (0));
        map.put ("英雄一",people.get (1));
        map.put ("英雄一",people.get (2));
        map.put ("英雄二",people.get (3));
        for (String s:map.keySet ()
             ) {
            System.out.println (s+map.get (s).toString ());
        }
    }
    private static void fun2(Map< Person,String> map, LinkedList<Person> people) {
        map.put (people.get (0),"英雄三");
        map.put (people.get (1),"英雄一");
        map.put (people.get (2),"英雄一");
        map.put (people.get (3),"英雄二");
        for (Person s:map.keySet ()
        ) {
            System.out.println (s+map.get (s).toString ());
        }
    }
}
