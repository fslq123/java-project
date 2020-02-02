package com.fslqup.day03;

import com.fslqup.day01.Object.Person;

import java.util.HashSet;
import java.util.Iterator;

/*使用HashSet时需重写equals和Hashcode方法
* */
public class DemoHashSet {


    public static void main(String[] args) {
        Person person1=new Person ("老王",43);
        Person person2=new Person ("老王",43);

        HashSet<Person> p1=new HashSet<> ();
        HashSet<Person> p2=new HashSet<> ();

        p1.add (person1);
        p2.add (person2);

        System.out.println (p1.equals (p2));
        System.out.println (p1.hashCode ());
        System.out.println (p2.hashCode ());
    }
}
