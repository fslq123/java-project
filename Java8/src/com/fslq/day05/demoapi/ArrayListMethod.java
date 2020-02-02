package com.fslq.day05.demoapi;

import java.util.ArrayList;
import java.util.Random;

/*
* public boolean add(E e)
* public E get(index i)
* public remove
* */
public class ArrayListMethod {

    public static void main(String[] args) {
        //NO 1.
      baseMethods();
        //NO 2.
      ArrayList<Integer> arrayList=new ArrayList<>();
      traverseArrayList(createArrayList());
       //NO 3.
       traverseAppleArrayList(createAppleArrayList());
    }

    public static void baseMethods(){
        ArrayList<String> arrayList=new ArrayList();
        arrayList.add("爸爸");
        arrayList.add("妈妈");
        arrayList.add("姐姐");

        for (String str:arrayList
        ) {
            System.out.println(arrayList.indexOf(str)+":"+str);
        }

        System.out.println(arrayList);
        System.out.println(arrayList.get(1));

        arrayList.remove("姐姐");
        System.out.println(arrayList);

        arrayList.remove(0);
        System.out.println(arrayList);
    }
    /*create*/
    public static ArrayList<Integer> createArrayList(){
        ArrayList<Integer> arrayList=new ArrayList<>();
        Random random=new Random();
        for (int i = 0; i <10 ; i++) {
            arrayList.add(random.nextInt(33));
        }
        return arrayList;
    }
    /*traverse*/
    public static void traverseArrayList(ArrayList<Integer> arrayList){
        for (Integer i:arrayList
             ) {
            System.out.println("第"+(arrayList.indexOf(i)+1)+"个："+i);
        }
    }
    /*create Apple Object ArrayList  */
    public static ArrayList<Apple> createAppleArrayList(){
        ArrayList<Apple> appleArrayList=new ArrayList<Apple>();
        Apple one=new Apple("红苹果",15.5F);
        Apple two=new Apple("青苹果",11.2f);
        appleArrayList.add(one);
        appleArrayList.add(two);
        return appleArrayList;
    }
    //traverse
    public static void traverseAppleArrayList(ArrayList<Apple> appleArrayList){
        for (Apple apple:appleArrayList)
            System.out.println("称号："+apple.getColor()+" ,单价："+apple.getPrize());
    }
}
