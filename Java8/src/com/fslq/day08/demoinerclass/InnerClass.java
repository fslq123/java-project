package com.fslq.day08.demoinerclass;

public class InnerClass {
    int num=10;
    public class NextClass{
        int num=20;
        public void innerMethod(){
            System.out.println ("内部变量："+this.num);
            System.out.println ("外部变量："+InnerClass.this.num);
        }
    }
}
