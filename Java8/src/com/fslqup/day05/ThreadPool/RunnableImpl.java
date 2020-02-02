package com.fslqup.day05.ThreadPool;
/*实现Runnable接口*/
public class RunnableImpl implements Runnable {
    @Override
    public void run() {
        System.out.println("当前线程名称："+Thread.currentThread().getName());
    }
}
