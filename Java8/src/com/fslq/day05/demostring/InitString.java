package com.fslq.day05.demostring;

public class InitString {
    public static void main(String[] args) {
        //使用空参数构造
        String str1=new String();

        //字符数组
        char[] charArray={'A','B','c','D'};
        String str2=new String(charArray);

        //字节数组
        byte[] byteArray={97,67,98};
        String str3=new String(byteArray);

        //直接初始化
        String str4="Hello World!";
        System.out.println(str4.substring(6,9));

        byte[] bytes=str3.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }

        String str5 = str4.replace("Hello", "你好");
        System.out.println(str5);
    }
}
