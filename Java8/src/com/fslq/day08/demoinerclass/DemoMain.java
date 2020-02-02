package com.fslq.day08.demoinerclass;

import java.lang.invoke.MethodHandles;

public class DemoMain {
    public static void main(String[] args) {
        //成员内部类
        InnerClass innerClass=new InnerClass ();
        InnerClass.NextClass nextClass=innerClass.new NextClass ();
        nextClass.innerMethod ();

        //局部内部类
        LocalMethod ();

        //匿名内部类:在创建对象时只能使用唯一一次
        MyInterface obj=new MyInterface () {
            @Override
            public void method() {
                System.out.println ("匿名内部类实现的方法");
            }
        };
        obj.method ();
        MyInterface objnext=new MyInterface () {
            @Override
            public void method() {
                System.out.println ("匿名内部类再次实现的方法");
            }
        };
        objnext.method ();
        new MyInterface (){
            @Override
            public void method() {
                System.out.println ("匿名实现匿名内部类");
            }
        }.method ();


    }

    public static void LocalMethod(){
        class Inner{
            final int num=100;
            public void Method(){
                System.out.println ("局部类变量："+this.num);//num为final:生命周期
            }
        }
        //调用
        Inner inner=new Inner ();
        inner.Method ();
    }
}
