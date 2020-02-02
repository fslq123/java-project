package com.fslqup.day03;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DemoList {
    public static void main(String[] args) {
        List<String> list=new ArrayList<> ();
        list.add("你好");
        list.add ("朋友");
        list.add ("哈哈");
        list.add (1,"我的");
        System.out.println (list);
        list.remove (2);

        list.set (2,"呵呵呵");
        Iterator<String> iterator=list.iterator ();
        while (iterator.hasNext ())
            System.out.println (iterator.next ());
        for (String s : list) {
            System.out.println (s);
        }
    }
}
