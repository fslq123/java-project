package com.fslq.day08.democonclusion;

public class Computer {
    public void powerOn(){
        System.out.println ("打开电脑");
    }
    public void powerOff(){
        System.out.println ("关闭电脑");
    }
    public void useDevice(USB usb){
        usb.open ();//打开设备
        /*向下转型判断*/
        if(usb instanceof Mouse){
            Mouse mouse=(Mouse) usb;
            mouse.click ();
        }else if (usb instanceof KeyBoard){
            KeyBoard keyBoard=(KeyBoard)usb;
            keyBoard.type ();
        }
        usb.close ();//关闭设备
    }
}
