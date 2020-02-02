package com.fslqup.day06.Lambda;

/* Lambda表达式:
 *1.void型
 *  new XX(X a,X b,..){}  <=>  (X a,X b,..)->{}
 * 2.非void
 *
 * */
public class DemoLambda {
    public static void main(String[] args) {
 /*       //匿名内部类
        new Thread( new Runnable() {
            @Override
            public void run() {
                System.out.println( "当前线程：" + Thread.currentThread().getName() );
            }
        }).start();

        //Lambda表达式
        new Thread(()-> {
                System.out.println( "当前线程：" + Thread.currentThread().getName() );
            }
        ).start();
*/
        /*自定义实现*/
        new Cat(new Animal() {
            @Override
            public void eat() {
                System.out.println("吃泥鳅");
            }
        }).eat();
        //Lambda实现自定义接口类
        new Cat(()->{
            System.out.println("吃黄鳝");
        }).eat();

        //Lambda实现自定义方法
        Dog(()->{
            System.out.println("吃屎");
        });

        /*有参有返回值*/
        calc(10,20,(int a,int b)->{
            return a+b;
        });
        //优化省略：方法体只有一行代码时（可推断）
        calc(30,20,(a,b)->a+b);
    }

    public static void Dog(Animal animal) {
        animal.eat();
    }

    public static void calc(int a,int b,NumberMethod numberMethod) {
        System.out.println("有参有返回值:"+numberMethod.sum(a,b));
    }
}
