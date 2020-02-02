package com.fslqup.day05.ThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolMain {
    public static void main(String[] args) {
        /*线程池：存储多个线程
        *
        * */
        //1.创建线程池
        ExecutorService threadPool=Executors.newFixedThreadPool(3);
        //2.添加线程
        threadPool.submit( new RunnableImpl() );
        threadPool.submit( new RunnableImpl() );
        threadPool.submit( new RunnableImpl() );
        //3.调用线程

        //4.关闭线程池
        threadPool.shutdown();
    }
}
