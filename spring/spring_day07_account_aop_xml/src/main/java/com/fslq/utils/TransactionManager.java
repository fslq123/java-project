package com.fslq.utils;
/*
* 事务管理工具类
* */
public class TransactionManager {
    private ConnectUtils connectionUtils;
    public void setConnectionUtils(ConnectUtils connectionUtils) {
        this.connectionUtils=connectionUtils;
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
}
