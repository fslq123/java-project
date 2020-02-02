package com.fslqup.day05.Synchronized;
/*
* 等待唤醒案例：线程之间的通信
*   创建一个顾客线程（消费者）：告知老板要的包子的种类和数量，调用wait方法，放弃cpu的执行，进行到WAITING状态（无限等待）
*   创建一个老板线程（生产者）：花了5秒做包子，做好包子之后，调用notify方法，唤醒顾客吃包子
* 注意：
*   顾客和老板线程必须使用代码块包裹起来，保证等待和唤醒只有一个在执行
*   同步使用的锁对象必须保证唯一
*   只有对象才能调用wait和notify方法
* */
public class WaitAndNotify {
    public static void main(String[] args) {
        //创建锁对象
        Object object=new Object ();
        //创建一个顾客线程（消费者）

        for (int i = 0; i < 5; i++) {
            new Thread (){
                @Override
                public void run() {
                    synchronized (object){
                        System.out.println ("消费者");
                        try {
                            object.wait ();
                        } catch (InterruptedException e) {
                            e.printStackTrace ();
                        }

                    }
                }
            }.start ();
        }
        System.out.println ("开吃包子");


        //创建一个老板线程（生产者）
        new Thread (){
            @Override
            public void run() {
                //花了5秒做包子
                try {
                    Thread.sleep (5000);
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
                synchronized (object){
                    System.out.println ("老板5秒钟之后做好包子，告知顾客，可以吃包子");
                    object.notifyAll ();
                }
            }
        }.start ();
    }
}
