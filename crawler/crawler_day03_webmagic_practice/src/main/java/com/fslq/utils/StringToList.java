package com.fslq.utils;

import org.junit.Test;

//字符串以空格分隔
public  interface StringToList {
    static String[] fun(String str){//str="北京-海淀区    3-4年经验    本科    招2人    03-25发布"
        String[] split=str.split( "\\s*" );
        for (int i=0,j=1; i <split.length ; i++) {
            while (split[j].hashCode()!=160&&j<split.length-1){//以hashcode判断空格，不是空格原位连接
                split[i]=split[i]+split[j];
                split[j]="";
                j++;
            }
            while (split[j].hashCode()==160&&j<split.length){//是空格，向下移动
                j++;
            }
            if(j==split.length-1)//填补最后一个集合值
            {
                split[i]=split[i]+split[j];
                while (i<split.length-1)//释放数组空间
                    split[++i]=null;
                break;
            }
        }
        return split;
    }
}
