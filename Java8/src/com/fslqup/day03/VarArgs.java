package com.fslqup.day03;

public class VarArgs {
    public static void main(String[] args) {
        Show ("可变","参数方法求和：",1,2,3,4,5,6,7,8,9,10);
    }
    public static void Show(String s,String s1,int... arr1){
        int Sum=0;
        for (int i : arr1) {
            Sum=Sum+i;
        }
        System.out.println (s+s1+Sum);
    }
}
