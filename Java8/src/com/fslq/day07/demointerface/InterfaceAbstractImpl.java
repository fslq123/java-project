package com.fslq.day07.demointerface;
/*
* 实现类可以同时继承多个接口
* */
public class InterfaceAbstractImpl implements InterfaceAbstract{

    @Override
    public void methodOne() {
        System.out.println("抽象方法一");
    }

    @Override
    public void methodTwo() {
        System.out.println("抽象方法二");
    }
    @Override
    public void methodThree(){//可或不可
        System.out.println("重写默认方法");
    }
}
