package com.fslqup.day05.Thread;

public class DemoRunnable {
    public static void main(String[] args) {
        //创建一个Runnable接口的实现类对象
        RunnableImpl run=new RunnableImpl ();
        //创建Thread类对象，构造方法中传递Runnable接口的实现类对象
        Thread thread=new Thread (run);
        thread.start ();
        for (int i = 0; i <20 ; i++) {
            System.out.println ("当前线程名称："+Thread.currentThread ().getName ()+"-->"+i);
        }


        new Thread (){
            //重写run方法,设置线程任务
            @Override
            public void run() {
                for (int i = 0; i <5; i++) {
                    System.out.println (Thread.currentThread ().getName ()+"-->"+"重写run方法");
                }
            }
        }.start ();
        //线程的接口Runnable
        //Runnable r=new RunnableImpl();//多态
        new Runnable (){
            @Override
            public void run() {
                System.out.println ("Runnable-->"+Thread.currentThread ().getName ());
            }
        }.run ();
    }
}
