package com.fslq.day08.demostatus;

public class DemoMain {
    public static void main(String[] args) {
        //多态
        Animal mice = new mice ();
        Animal car = new Car ();

        //向下转型
        Animal animal=new Car ();
        /*Car car1=(Car)animal;//ClassCastException
        car1.eat ();*/
        //判断父类引用是不是Car,必用格式
        if (animal instanceof Car){
            Car car1=(Car)animal;
            car1.eat ();
        }

        mice.eat ();
        car.eat ();
    }

}
