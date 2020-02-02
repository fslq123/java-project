package com.fslqup.day05.CustomerAndProducer;

import java.util.ArrayList;

public class DemoMain {
    public static void main(String[] args) {
        ArrayList<Apple> appleCase=new ArrayList<> (  );
        Thread producer=new Producer(appleCase);
        Thread customer=new Customer(appleCase);
        producer.start();

        customer.start();

    }
}
