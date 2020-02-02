package com.fslqup.day07.Stream;

import java.util.*;
import java.util.stream.Stream;

/*
* Stream:处理集合 JDK1.8~
* 流水线模式
* Collection中单列集合都可以直接转换为流
* 注意：流在使用的过程中可能会终止
* */
public class DemoStream {
    public static void main(String[] args) {
        List<String> list=List.of("张无忌","张三丰","赵敏","周芷若");
        //打印输出张姓，3字
        list.stream().filter(name->name.startsWith("张"))//过滤：name为参数
                     .filter(name->name.length()==3)//过滤
                     .forEach(name->{//打印
                         System.out.println(name);
                     });

        //stream.map方法：数据类型转换 String->Integer
        Stream<String> stringStream=Stream.of("11","222","3333","44444","555555");
        stringStream.map((str)->Integer.parseInt(str)).forEach(integer ->System.out.println(integer));

        //.skip  .concat
       Stream.of("11","222","3333","44444","555555").skip(3).forEach((String list2)->{
           System.out.print(list2);
       });
        Stream<String> list1=Stream.of("张无忌","张三丰","赵敏","周芷若");
        Stream<String> list2=Stream.of("11","222","3333","44444","555555");
        Stream.concat(list1,list2).forEach((str)->System.out.print(str));

        /*各种数据的流转化*/
        //集合->Stream
        List<String> list3=new ArrayList<>();
        Stream<String> stream=list3.stream();

        Set<String> set=new HashSet<>();
        Stream<String> stream1=set.stream();

        //Map->Stream
        //键
        Map<String,Integer> map=new HashMap<>();
        Set<String> keySet=map.keySet();
        Stream<String> stream2=keySet.stream();
        //值
        Collection<Integer> values=map.values();
        Stream<Integer> stream3=values.stream();
        //映射
        Set<Map.Entry<String,Integer>> entries=map.entrySet();
        Stream<Map.Entry<String,Integer>> stream4=entries.stream();

        //数组->Stream
        Stream<Integer> stream5=Stream.of(1,2,3,4,5);
        Integer[] arr={1,2,3,4,5};
        Stream<Integer> stream6=Stream.of(arr);
        System.out.println("截取前三个元素：");
        stream6.limit(3).forEach(integer ->System.out.println(integer));
        System.out.println("统计结果："+stream5.count());
    }
}
