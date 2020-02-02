package com.fslqup.day07.FunctionInterface;

import java.util.function.Function;

//apply:类型转换
//andThen
//不同类型字符拼接
//fun1截取String; fun2截取Integer; fun3 add
public class DemoFunction
{
    public static int methods(String str,Function<String,String> fun1,Function<String,Integer> fun2,Function<Integer,Integer> fun3){
        return fun1.andThen(fun2).andThen(fun3).apply(str);
    }

    public static void main(String[] args) {
        String str="古利札那，18";
        System.out.println(
        methods(str,(message)->str.split("，")[1]//==>strage
                   ,(strage)->Integer.parseInt(strage)//==>age
                   ,(age)->age+100)
        );
    }
}
