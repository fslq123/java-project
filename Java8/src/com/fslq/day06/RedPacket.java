package com.fslq.day06;

import java.util.ArrayList;

public class RedPacket {
    public static void main(String[] args) {
        Manager manager=new Manager("群主",100);
        Members one=new Members("小明",10);
        Members two=new Members("小红",20);
        Members three=new Members("小兰",30);
        Members four=new Members("小黄",0);
        manager.show();

        ArrayList<Members> membersArrayList=new ArrayList<>();
        membersArrayList.add(one);
        membersArrayList.add(two);
        membersArrayList.add(three);
        membersArrayList.add(four);
        for (Members mem:membersArrayList
             ) {
            mem.show();
        }
        System.out.println("=======================");
        ArrayList<Integer> redList=manager.send(60,Members.intcount);
        manager.show();
        for (Members mem:membersArrayList
        ) {
            mem.receive(redList);
        }
        for (Members mem:membersArrayList
        ) {
            mem.show();
        }
    }
}
