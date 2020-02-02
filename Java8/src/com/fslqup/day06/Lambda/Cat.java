package com.fslqup.day06.Lambda;

public class Cat implements Animal {
    static int count=0;
    public Cat(Animal animal) {
        animal.eat();
    }

    @Override
    public void eat() {
        System.out.println("吃鱼"+count++);
    }
}
