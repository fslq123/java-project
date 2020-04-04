package com.fslq.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/*
* 用于记录日志，有公共代码
* */
public class Logger {
    //前置通知：打印日志，于切入点方法前执行
    public void prePrintLog(){
        System.out.println( "----------前置日志" );
    }
    //后置通知
    public void afterPrintLog(){
        System.out.println( "----------结束日志。。。" );
    }
    //异常通知
    public void excepPrintLog(){
        System.out.println( "----------异常日志。。。" );
    }
    //最终通知
    public void finalPrintLog(){
        System.out.println( "----------最终日志。。。" );
    }

    public Object arroundPrintLog(ProceedingJoinPoint pjp){
//        配置环绕通知
        Object rtValue=null;
        try {
            Object[] args=pjp.getArgs();
            //前置通知
            System.out.println( "----------前置日志" );
            rtValue=pjp.proceed( args );
            //后置通知
            System.out.println( "----------结束日志。。。" );
            return rtValue;
        }catch(Throwable throwable){
            //异常通知
            System.out.println( "----------异常日志。。。" );
            throwable.printStackTrace();
        }finally {
            //最终通知
            System.out.println( "----------最终日志。。。" );
        }
        return rtValue;
    }
}
