package com.fslqup.day04.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapMethod {
    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<> ();
        fun1(map);
        //遍历
        traverse(map);

    }

    private static void traverse(Map<String, Integer> map) {
        /*KeySet():通过键值找value*/
        //迭代器
        Iterator<String> iterator=map.keySet ().iterator ();
        while (iterator.hasNext ()){
            String string=iterator.next ();
            System.out.println (string+map.get (string));
        }
        //foreach 1
        for (String str:map.keySet ()
             ) {
            System.out.println (str+map.get (str));
        }
        //foreach 2
        map.forEach ((key, value) -> {
            System.out.println (key+value);
        });
        //foreach 3
        for (Map.Entry<String,Integer> mapEntry:map.entrySet ()
             ) {
            System.out.println (mapEntry);
        }
    }

    private static void fun1(Map<String,Integer> map) {
        map.put ("刘亦菲",18);
        map.put ("杨幂",17);
        map.put ("林志玲",15);
        System.out.println (map);
        if (!map.containsKey (18)&&!map.containsValue ("刘亦菲")) {
            System.out.println ("刘亦菲的Key:"+map.get ("刘亦菲"));
        }
    }
}
