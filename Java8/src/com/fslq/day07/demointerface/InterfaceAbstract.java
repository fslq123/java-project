package com.fslq.day07.demointerface;
/*
* 接口中都是抽象方法
* jdk8中新增默认方法
* 接口中声明变量为final类型
* */
public interface InterfaceAbstract {
    public abstract void methodOne();
    void methodTwo();

    default void methodThree(){
        System.out.println("默认方法，用于更新！");
    }

    static void methodFour(){
        System.out.println("静态方法");
    }

}
