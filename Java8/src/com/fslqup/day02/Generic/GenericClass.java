package com.fslqup.day02.Generic;

public class GenericClass<E> {
    private E name;

    public GenericClass(E name) {
        this.name = name;
    }

    public <M> void GenericMethod(M m){
        System.out.println ("泛型方法实现："+m);
    }
    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }
}
