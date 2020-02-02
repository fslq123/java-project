package com.fslqup.day05.CustomerAndProducer;

import java.util.ArrayList;

public class Producer extends  Thread{
    private ArrayList<Apple> appleCase;//苹果箱
    private int count=0;

    public Producer(ArrayList<Apple> appleCase) {
        this.appleCase = appleCase;
    }


    @Override
    public void run() {
        while (true){

            synchronized ( appleCase ) {

                if ( appleCase.isEmpty ( ) ) {
                    appleCase.notify ();//唤醒
                    if ( count % 2 == 0 )
                        appleCase.add ( new Apple ( "酸的", "青苹果" ) );
                    else
                        appleCase.add ( new Apple ( "甜的", "红苹果" ) );
                    System.out.println ( "装苹果" );
                } else {
                    try {
                        //阻塞
                        appleCase.wait ( );
                    } catch ( InterruptedException e ) {
                        e.printStackTrace ( );
                    }
                }
                try {
                    Thread.sleep( 1000 );
                } catch ( InterruptedException e ) {
                    e.printStackTrace();
                }
                count++;
            }
        }
    }
}
