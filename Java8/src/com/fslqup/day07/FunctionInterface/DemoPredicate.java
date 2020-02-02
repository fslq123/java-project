package com.fslqup.day07.FunctionInterface;

import java.util.ArrayList;
import java.util.function.Predicate;

/*
* Predicate:判断，是则返回true
* 练习： String[] arr={"迪丽热巴，女","古力娜扎，女","邓超，男","赵丽颖,女","马尔扎哈，男"};
* ==>           list={"迪丽热巴，女","古力娜扎，女"};
* */
public class DemoPredicate {
    //过滤
    public  static ArrayList<String> filter(String[] arr,Predicate<String> pre1,Predicate<String> pre2){
        ArrayList<String> arrayList=new ArrayList<>();
        //遍历数组
        for (String s : arr) {
            if(pre1.and(pre2).test(s)){//判断：&&
                arrayList.add(s);
            }
        }
        return  arrayList;
    }

    public static void main(String[] args) {
        String[] arr={"迪丽热巴，女","古力娜扎，女","邓超，男","赵丽颖,女","马尔扎哈，男"};
        //过滤
        ArrayList<String> filter=filter(arr,(name)->{
            return name.split("，")[0].length()==4;
        },(sex)->{
            return sex.split("，")[1].equals("女");
        });
        //遍历
        for (String s : filter) {
            System.out.println(s);
        }
    }
}
