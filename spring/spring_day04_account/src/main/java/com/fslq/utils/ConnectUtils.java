package com.fslq.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/*
* 连接的工具类，用于从数据源中获取一个连接，并且实现和线程的绑定
* */
public class ConnectUtils {
    private ThreadLocal<Connection> threadLocal=new ThreadLocal<>();
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource=dataSource;
    }

    //获取当前线程上的连接
    public Connection getTheadConnection(){
        //1.从线程上获取
        try {
            Connection conn=threadLocal.get();
            //2.判断当前线程上是否有连接
            if(conn==null){
                //3.从数据源中获取一个连接，并存入当前线程中
                conn=dataSource.getConnection();
                threadLocal.set( conn );
                return conn;
            }
        }catch(SQLException e){
                e.printStackTrace();
        }
        return null;
    }
    //移除线程的连接
    public void removeConnection(){
        threadLocal.remove();
    }
}
