package com.fslqup.day04.Map;

import java.util.*;

public class Game {
    public static void main(String[] args) {
        //1.准备牌
        int index=0;
        LinkedHashMap<Integer,String> poker=new LinkedHashMap<> ();
        //Jdk9特性
        List<String> colors=List.of ("♠", "♥", "♣", "♦");
        List<String> numbers=List.of ("2","A","K","Q","J","10","9","8","7","6","5","4","3");
        poker.put (index++,"大王");
        poker.put (index++,"小王");
        for (String num:numbers
             ) {
            for (String col:colors
                 ) {
                poker.put (index++,col+num);
            }
        }
        System.out.println (poker);
        //2.洗牌
        List<Integer> list=new LinkedList<> ();
        for (int i = 0; i <54 ; i++) {
            list.add (i);
        }
        Collections.shuffle (list);
        System.out.println (list);

        //发牌
        Set<Integer> lowpoker=new HashSet<> ();//以集合存储防止重复
        List<Integer> player1=new LinkedList<> ();
        List<Integer> player2=new LinkedList<> ();
        List<Integer> player3=new LinkedList<> ();
        /*底牌*/
        int temp = 54;
        Random random=new Random ();
        while (lowpoker.size ()<3) {
            index=random.nextInt (temp--);
            lowpoker.add (list.get (index));
            list.remove (index);
        }
        System.out.println (lowpoker);
        System.out.println (list);
        /*玩家*/
        for (int i = 0; i <list.size () ; i++) {
            if(i%3==0){
                player1.add (list.get (i));
            }else if (i%3==1){
                player2.add (list.get (i));
            }else {
                player3.add (list.get (i));
            }
        }
        Collections.sort (player1);
        Collections.sort (player2);
        Collections.sort (player3);
        System.out.println (player1);
        System.out.println (player2);
        System.out.println (player3);

        //打印
        System.out.println ("赌圣：");
        for (int i = 0; i <player1.size () ; i++) {
            System.out.print (poker.get (player1.get (i))+" ");
        }

        System.out.println ("\n"+"赌王：");
        for (int i = 0; i <player2.size () ; i++) {
            System.out.print (poker.get (player2.get (i))+" ");
        }
        System.out.println ("\n赌侠：");
        for (int i = 0; i <player3.size () ; i++) {
            System.out.print (poker.get (player3.get (i))+" ");
        }
        /*HashSet遍历*/
        System.out.println ("\n底牌：");
        for (Integer i:lowpoker
             ) {
            System.out.print (poker.get (i)+" ");
        }
    }

}
