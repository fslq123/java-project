package com.fslq.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/*
*解析文件
* */
public class testJouspFile {
    @Test
    public void testFile() throws IOException {
        Document document=Jsoup.parse(  new File("D:\\WorkSpace\\Idea\\crawler\\crawler_day01_jsoup\\src\\main\\resources\\清华大学.html" ),"utf8" ) ;
        String title=document.getElementsByTag( "title" ).first().text();
        System.out.println(title);
    }
}
