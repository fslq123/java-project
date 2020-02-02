package com.fslqup.day02.Collection;
/*
* XXList:数组
* XXSet:集合
* */
import com.fslqup.day01.Object.Person;

import java.util.*;

public class FrequentMethods {

    public static void main(String[] args) {
        Collection<String> collection=new LinkedList<> ();//查询慢，增删快
        //添加
        collection.add ("Hello");
        collection.add ("World");
        Collections.addAll (collection,"hbbba","Habbb","HAbbb");
        System.out.println (collection);
        //删除
        boolean hello = collection.remove ("Hello ");
        if (hello==true)
            System.out.println ("删除成功");
        //查询
        if(collection.contains ("World"))
            System.out.println ("查找成功");
        //toArray
        Object[] array = collection.toArray ();
        for (Object obj:array
             ) {
            System.out.println (obj);
        }

        //排序
        LinkedList<String> linkedList=(LinkedList<String>)collection;
        Collections.sort (linkedList);
        System.out.println (linkedList);

        Person one=new Person ("赵六",25);
        Person two=new Person ("李氏",18);
        Person three=new Person ("王五",26);
        Person four=new Person ("张三",18);
        ArrayList<Person> arrayList=new ArrayList<> ();
        Collections.addAll (arrayList,one,two,three,four);
        /*Collections.sort (arrayList);*/
        Collections.sort (arrayList, new Comparator<Person> () {
            @Override
            public int compare(Person o1, Person o2) {//组合排序
                int re= o1.getAge ()-o2.getAge ();
                if (re==0)
                    re=o2.getName ().charAt (0)-o1.getName ().charAt (0);
                return re;
            }
        });
        System.out.println (arrayList);

        //清空
        if(!collection.isEmpty ())
        {
            collection.clear ();
            System.out.println ("已清空"+collection.toString ());
        }

    }
}
