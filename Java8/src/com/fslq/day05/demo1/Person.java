package com.fslq.day05.demo1;

public class Person {
    private boolean male;
    public String name;

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMale() {
        return male;
    }
    public void setMale(boolean male) {
        this.male = male;
    }

    //constructor
    public Person(String name,boolean male){
        this.male=male;
        System.out.print(name);
        System.out.print(male?"是":"不是");
        System.out.println("男人");

    }

    public void show(){
        System.out.println("我叫"+this.name);
    }
   /* public void print(String name){
        System.out.print(name);
        System.out.print(this.isMale()?"是":"不是");
        System.out.println("男人");


        System.out.print(this.name);
        System.out.print(this.isMale()?"是":"不是");
        System.out.println("男人");

    }*/
}
