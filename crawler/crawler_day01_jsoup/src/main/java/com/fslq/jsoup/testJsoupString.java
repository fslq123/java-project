package com.fslq.jsoup;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/*
* 解析页面字符串
* */
public class testJsoupString {
    @Test
    public void testString() throws IOException {
        //使用工具类读取文件，字符串
        String context= FileUtils.readFileToString( new File("D:\\WorkSpace\\Idea\\crawler\\crawler_day01_jsoup\\src\\main\\resources\\清华大学.html" ),"utf8" );
        //解析字符串
        Document document=Jsoup.parse( context );
        String title=document.getElementsByTag( "title" ).first().text();
        System.out.println( title );
    }
}
