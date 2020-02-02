package com.fslqup.day07.Reference;

public class ManReference extends Human {
    @Override
    public void sayHello() {
        System.out.println("我是Man!");
    }
    //用于实现接口中的方法
    public void method(Greet g){
        g.greet();
    }
    //打印：调用method方法
    public void show1(){
        method(()->{
            Human human=new Human();
            human.sayHello();
        });
    }
    public void show2(){
        method(()->{
            super.sayHello();
        });
    }
    public void show3(){
        method(super::sayHello);//子类实现引用 父类中 已经存在的方法
        method(this::sayHello);//子类实现引用 本类中 已经存在的方法
    }
    //MAIN方法
    public static void main(String[] args) {
        new ManReference().show1();
        new ManReference().show2();
        new ManReference().show3();
    }
}
