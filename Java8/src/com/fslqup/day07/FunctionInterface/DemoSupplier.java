package com.fslqup.day07.FunctionInterface;

import java.util.function.Supplier;

/*
* 定义泛型并实现返回泛型参数
* */
public class DemoSupplier {
    public static String getStr(Supplier<String> str){
        return str.get();
    }
    public static int getMax(Supplier<Integer> i){
        return i.get();
    }

    public static void main(String[] args) {
        System.out.println(getStr(()->"胡歌"));
        System.out.println(getMax(()->10>89?10:89));
    }
}
