package com.fslq.day07.demointerface;

public class TestMain {
    public static void main(String[] args) {
        InterfaceAbstractImpl interfaceAbstractImpl=new InterfaceAbstractImpl();
        interfaceAbstractImpl.methodOne();
        interfaceAbstractImpl.methodTwo();

        //默认方法
        interfaceAbstractImpl.methodThree();
        //静态方法
        InterfaceAbstract.methodFour();

    }
}
