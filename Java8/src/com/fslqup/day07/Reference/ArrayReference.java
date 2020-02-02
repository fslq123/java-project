package com.fslqup.day07.Reference;
/*
* 数组的构造器引用
* */
public class ArrayReference {
    //创建指定长度的数组
    public static int[] createArray(int len,ArrayBuilder arrayBuilder){
        return arrayBuilder.buildArray(len);
    }

    public static void main(String[] args) {
        int[] arr=createArray(10,(len)->new int[len]);
        System.out.println(arr.length   );
    }
}
