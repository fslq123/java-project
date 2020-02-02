package com.fslq.day08.demoredpack;

import com.fslq.day08.red.OpenMode;

import java.util.ArrayList;

public class NormalMode implements OpenMode {
    @Override
    public ArrayList<Integer> divide(int totalMoney, int totalCount) {
        ArrayList<Integer> arrayList=new ArrayList<> ();
        int avg=totalMoney/totalCount;
        int mod=totalMoney%totalCount;//零钱
        for (int i = 0; i <totalCount-1 ; i++) {
            arrayList.add (avg);
        }
        arrayList.add (avg+mod);
        return arrayList;
    }
}
