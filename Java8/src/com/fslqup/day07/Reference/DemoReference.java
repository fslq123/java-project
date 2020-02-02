package com.fslqup.day07.Reference;
/*
* Lamdba表达式实现引用 自定义类的静态方法
* */
public class DemoReference {
    public static int referMethod(int number,Calcu calcu){
        return calcu.abs(number);
    }

    public static void main(String[] args) {
        System.out.println(referMethod(-8,(num)->Math.abs(num)));//表达式实现
        System.out.println(referMethod(-8,Math::abs));//静态方法引用实现

    }
}
