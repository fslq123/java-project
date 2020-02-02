package com.fslqup.day01.StringBuilder;
/*
* 字符串缓冲区
* 没有final修饰，在内存中始终为一个数组
* 占用空间少
* */
public class DemoStringBuilder {
    public static void main(String[] args) {
        demo_append();
        demo_toString();
    }

    //StringBuilder与String转换
    private static void demo_toString() {
        String string="Hello ";
        StringBuffer stringBuffer=new StringBuffer (string);
        stringBuffer.append ("World");
        System.out.println ("StringBuilder->String:"+stringBuffer.toString ());
    }
    //添加
    private static void demo_append() {
        StringBuffer stringBuffer = new StringBuffer ();
        stringBuffer.append ("abc");
        stringBuffer.append (123);
        System.out.println (stringBuffer);

        //链式编程
        stringBuffer.append (123).append ("gewe");
        System.out.println (stringBuffer);
    }
}
