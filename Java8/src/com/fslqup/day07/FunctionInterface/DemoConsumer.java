package com.fslqup.day07.FunctionInterface;

import java.util.function.Consumer;

/*
* 消费接口，不返回值
* */
public class DemoConsumer {
    public static void strReverse(String name,Consumer<String> str){
        str.accept(name);
    }

    //连接
    public static void connMethod(String s,Consumer<String> con1,Consumer<String> con2){
        con1.andThen(con2).accept(s);
    }

    //切分
    public static void splitMethod(String[] arr,Consumer<String> con1,Consumer<String> con2){
        for (String s : arr) {
            con1.andThen(con2).accept(s);
        }
    }
    public static void main(String[] args) {
        strReverse("支付宝",(name)->{
            System.out.println(new StringBuffer(name).reverse().toString());//反转
        });

        connMethod("hELLO",(t)->{
            System.out.println(t.toLowerCase());
                            },(t)->{
            System.out.println(t.toUpperCase());
        });

        String[] arr={"迪丽热巴，女","古力娜扎，女","邓超    ，男"};
        splitMethod(arr,(str)->{
            String[] split=str.split("，");
            System.out.print("姓名："+split[0]);
        },(str)->{
            String[] split=str.split("，");
            System.out.println("\t年龄："+split[1]);
        });
    }
}
