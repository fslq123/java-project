package com.fslq.day06;

import java.util.ArrayList;
import java.util.Random;

public class Members extends User {
    static Integer intcount=0;//统计人数
    public Members(){

    }

    public Members(String name, Integer money) {
        super(name, money);
        intcount++;
    }

    public  void receive(ArrayList<Integer> list){
        int index=new Random().nextInt(list.size());
        int delta=list.remove(index);
        int money=super.getMoney();
        super.setMoney(delta+money);
    }
}
