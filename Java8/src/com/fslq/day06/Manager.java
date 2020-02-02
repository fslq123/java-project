package com.fslq.day06;

import java.util.ArrayList;
import java.util.Random;

public class Manager extends User {
    public Manager(){}
    public Manager(String name, Integer money) {
        super(name, money);
    }

    public ArrayList<Integer> send(int totalMoney,int count){
        ArrayList<Integer> redList=new ArrayList<>();

        int leftMoney=super.getMoney();//查看余额
        if(totalMoney>leftMoney){
            System.out.println("余额不足");
            return redList;//返回空集
        }

        //塞钱
        Random random=new Random();
        int sum=0;
        for (int i = 1; i <count ; i++) {
            int temp=random.nextInt(totalMoney/count);
            redList.add(temp);
            sum=temp+sum;
        }
        redList.add(totalMoney-sum);
        this.setMoney(leftMoney-totalMoney);
        return  redList;
    }
}

