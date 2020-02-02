package com.fslqup.day05.CustomerAndProducer;

import java.util.ArrayList;

public class Customer extends Thread {
    private ArrayList<Apple> appleCase;

    public ArrayList<Apple> getAppleCase() {
        return appleCase;
    }

    public void setAppleCase(ArrayList<Apple> appleCase) {
        this.appleCase = appleCase;
    }

    public Customer(ArrayList<Apple> appleCase) {
        this.appleCase = appleCase;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep( 1000 );
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
            synchronized (appleCase ){
                if(!appleCase.isEmpty ()){
                    appleCase.notify ();//唤醒
                    System.out.println ("吃了"+appleCase.get (0).getTaste()+appleCase.get(0).getColor());
                    appleCase.remove ( 0 );
                }
                else {
                    try {
                        appleCase.wait ();//阻塞
                    } catch ( InterruptedException e ) {
                        e.printStackTrace ( );
                    }
                }
            }
        }
    }

}
