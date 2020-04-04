package com.fslq.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
* 事务管理工具类
* */
@Component("transactionManager")
@Aspect
public class TransactionManager {
    @Autowired
    private ConnectUtils connectionUtils;

    //配置方法
    @Pointcut("execution(* com.fslq.Impl.*.*(..))")
    private void pc(){
    }
    //开启
    public void begin(){
        try {
            connectionUtils.getTheadConnection().setAutoCommit( false );
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //提交
    public void commit(){
        try {
            connectionUtils.getTheadConnection().commit( );
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //回滚
    public void rollback(){
        try {
            connectionUtils.getTheadConnection().rollback( );
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //释放
    public void release(){
        try {
            connectionUtils.getTheadConnection().close();//还回线程池
            connectionUtils.removeConnection();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Around( "pc()" )
    public Object aroundTranManager(ProceedingJoinPoint pjp){
        Object rtValue=null;
        try{
            Object[] args=pjp.getArgs();
            //前置通知
            begin();
            rtValue=pjp.proceed(args);
            //后置通知
            commit();
            return rtValue;
        }catch(Throwable throwable){
            //异常通知
            rollback();
            throwable.printStackTrace();
        }finally {
            //最终通知
            release();
        }
        return rtValue;
    }
}
