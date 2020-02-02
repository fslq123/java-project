package com.fslqup.day02.Practice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*
1.准备牌
2.洗牌
3.发牌
4.打印牌
* */
public class Game {

    public static void main(String[] args) {
        ArrayList<String> pokerList=new ArrayList<> ();
        //准备牌
        readyPoker( pokerList);
        //洗牌
        Collections.shuffle (pokerList);
        //发牌
        ArrayList<String> player1 = new ArrayList<> ();
        ArrayList<String> player2 = new ArrayList<> ();
        ArrayList<String> player3 = new ArrayList<> ();
        ArrayList<String> lowpoker = new ArrayList<> ();
        sendPoker(pokerList,player1,player2,player3,lowpoker);


        System.out.println ("牌面："+pokerList);
        System.out.println ("赌圣："+player1);
        System.out.println ("赌王："+player2);
        System.out.println ("赌侠："+player3);
        System.out.println ("底牌："+lowpoker);
    }

    private static void sendPoker(ArrayList<String> pokerList, ArrayList<String> player1, ArrayList<String> player2, ArrayList<String> player3, ArrayList<String> lowpoker) {
        for (int i=0;i<3;i++){
            lowpoker.add (pokerList.get (i));
        }
        for (int i=0;i<3;i++){
            pokerList.remove (0);
        }
        for (int i = 0; i <pokerList.size () ; i++) {
            if(i%3==0){
                player1.add (pokerList.get (i));
            }else if (i%3==1){
                player2.add (pokerList.get (i));
            }else {
                player3.add (pokerList.get (i));
            }
        }
    }

    private static void readyPoker(ArrayList<String> pokerList) {
        String[] colors={"♠", "♥", "♣", "♦"};
        String[] numbers={"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
        pokerList.add ("大王");
        pokerList.add ("小王");
        for (String color:colors//组装牌
             ) {
            for (String number:numbers
                 ) {
                pokerList.add (color+number);
            }
        }
    }

}
