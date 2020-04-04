package com.fslq.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;
import java.net.URL;

/*
* 解析Url
* */
public class testJsoupUrl {
    @Test
    public void testUrl() throws Exception {
        //解析Url地址
        Document document=Jsoup.parse( new URL( "https://www.tsinghua.edu.cn"),3000 ) ;
        //获取title内容
        Element element=document.getElementsByTag("title").first();
        System.out.println( element );
    }
}
