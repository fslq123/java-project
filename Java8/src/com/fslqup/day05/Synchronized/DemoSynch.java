package com.fslqup.day05.Synchronized;

public class DemoSynch {
    public static void main(String[] args) {
       // fun1();
        fun2();
    }

    private static synchronized void fun2() {
        int ticket=10;
        if(ticket>0){
            try {
                Thread.sleep (10);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
            //票存在，卖票
            System.out.println (Thread.currentThread ().getName ()+"-->正在卖第"+ticket+"张票");
            ticket--;
        }
    }

    private static void fun1() {
        new Thread (){
            Object obj=new Object ();
            private int ticket=100;
            @Override
            public void run() {
                while (true){
                    //同步代码块
                    synchronized (obj){
                        //先判断票是否存在
                        if(ticket>0){
                            try {
                                Thread.sleep (10);
                            } catch (InterruptedException e) {
                                e.printStackTrace ();
                            }
                            //票存在，卖票
                            System.out.println (Thread.currentThread ().getName ()+"-->正在卖第"+ticket+"张票");
                            ticket--;
                        }
                    }
                }
            }
        }.run ();
    }
}
