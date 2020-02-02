package com.fslqup.day01.Object;

import java.util.Objects;
import java.util.Comparator;
public class Person implements Comparable<Person>{
    private Integer age;
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {
    }

    public Person(String name,Integer age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Person person = (Person) o;
        return Objects.equals (age, person.age) &&
                Objects.equals (name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash (age, name);
    }

    @Override//必须实现接口
    public int compareTo(Person p){
        return this.getAge ()-p.getAge ();
    }

  /*  @Override
    public boolean equals(Object obj) {
        //代码优化
        if(obj==null)
            return false;
        if(obj==this)
            return true;
        //向下转型
        if (obj instanceof Person){//检查
            Person person=(Person)obj;
            return this.name.equals (person.name)&&this.age==person.age;
        }
        else
            return false;
    }*/
}
