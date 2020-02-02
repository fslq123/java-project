package com.fslq.day08.democonclusion;

public class DemoRun {
    public static void main(String[] args) {
        //实例化
        Computer computer=new Computer ();
        Mouse mouse=new Mouse ();
        //USB mouseUsb=(USB)mouse;
        KeyBoard keyBoard=new KeyBoard ();

        //实现
        computer.powerOn ();
        computer.useDevice (mouse);
        //computer.useDevice (mouseUsb);
        computer.useDevice (keyBoard);
        computer.powerOff ();
    }
}
