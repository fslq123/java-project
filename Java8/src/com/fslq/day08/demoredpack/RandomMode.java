package com.fslq.day08.demoredpack;

import com.fslq.day08.red.OpenMode;

import java.util.ArrayList;
import java.util.Random;

public class RandomMode implements OpenMode {
    @Override
    public ArrayList<Integer> divide(int totalMoney, int totalCount) {
        ArrayList<Integer> redList=new ArrayList<>();


        //塞钱
        Random random=new Random();
        int sum=0;
        for (int i = 1; i <totalCount ; i++) {
            int temp=random.nextInt(totalMoney/totalCount);
            redList.add(temp);
            sum=temp+sum;
        }
        redList.add(totalMoney-sum);
        return  redList;
    }
}
