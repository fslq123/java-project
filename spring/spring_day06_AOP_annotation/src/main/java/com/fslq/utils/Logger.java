package com.fslq.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/*
* 用于记录日志，有公共代码
* */
//配置logger类
@Component("logger")
//配置切面
@Aspect
public class Logger {
    //配置切入点表达式
    @Pointcut("execution(* *.*.*.*.*(..))")
    private void pt(){}
    //前置通知：打印日志，于切入点方法前执行
   /* @Before("pt()")
    public void prePrintLog(){
        System.out.println( "----------前置日志" );
    }
    //后置通知
    @AfterReturning("pt()")
    public void afterPrintLog(){
        System.out.println( "----------结束日志。。。" );
    }
    //异常通知
    @AfterThrowing("pt()")
    public void excepPrintLog(){
        System.out.println( "----------异常日志。。。" );
    }
    //最终通知
    @After("pt()")
    public void finalPrintLog(){
        System.out.println( "----------最终日志。。。" );
    }*/
    //配置环绕通知
    @Around("pt()")
    public Object arroundPrintLog(ProceedingJoinPoint pjp){

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
