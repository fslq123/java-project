package com.fslqup.day05.Exception;

import java.util.Scanner;

/*自定义异常*/
public class ExceptionMain {
    static String[] usernames={"张三","李四","王五"};

    public static void main(String[] args) throws MyException {
        Scanner scanner=new Scanner (System.in);
        System.out.print ("请输入您要注册的用户名：");
        String username=scanner.next ();
        checkUsername (username);
    }
    public static void checkUsername(String username) throws MyException {
        for (String name:usernames
             ) {
            if (name.equals (username)){
                try{
                    throw new MyException ("已经被注册！");
                }catch (MyException e){
                    System.out.println ("异常了！！！");
                    return;//暂停异常
                }
            }
        }
        System.out.println ("恭喜注册正常！");
    }
}
