package com.fslqup.day02.Iterator;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class DemoIteror {
    public static void main(String[] args) {
        Collection<String> collection=new LinkedHashSet<> ();
        collection.add ("你好");
        collection.add ("世界");
        collection.add ("哈哈");

        Iterator<String> integer=collection.iterator ();
        while (integer.hasNext ())
            System.out.println (integer.next ());
        System.out.println (collection);
    }
}
