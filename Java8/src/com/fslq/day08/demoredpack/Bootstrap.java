package com.fslq.day08.demoredpack;

import com.fslq.day08.red.OpenMode;

public class Bootstrap {
    public static void main(String[] args) {
        Red red=new Red ("FSLQ");
        OpenMode normal=new NormalMode ();
        OpenMode random=new RandomMode ();
        //red.setOpenWay (normal);
        red.setOpenWay (random);
    }
}
