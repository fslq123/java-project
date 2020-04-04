package com.fslq.dom;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Set;

/*
* dom遍历
* */
public class testHtml {
    //@Test
    public void traverTest() throws IOException {
        //解析文件
        Document document=Jsoup.parse( new File("D:\\WorkSpace\\Idea\\crawler\\crawler_day01_jsoup\\src\\main\\resources\\清华大学.html" ),"utf8" );

        //1.根据id
        Element element=document.getElementById( "header" );
        System.out.println("根据id"+element);
        //2.根据标签
        Element element1=document.getElementsByTag( "title" ).first();
        System.out.println("根据标签"+element1);
        //3.根据class
        Element element2=document.getElementsByClass( "section_1" ).first();//class="section_1" ...
        System.out.println("根据class"+element2);
        //4.根据属性
        Element element3=document.getElementsByAttribute( "href" ).first();
        System.out.println("根据属性"+element3);
        //5.根据属性值
        Element element4=document.getElementsByAttributeValue( "href", "/publish/newthu/newthu_cnt/faculties/index.html").first();
        System.out.println("根据属性值"+element4);
    }
    @Test
    public void obainData() throws IOException {
        //解析文件
        Document document=Jsoup.parse( new File("D:\\WorkSpace\\Idea\\crawler\\crawler_day01_jsoup\\src\\main\\resources\\清华大学.html" ),"utf8" );
        //获取id的元素
        Element element=document.getElementById( "header" );
        System.out.println("根据id"+element);
        //从元素中获取
            //1.id
            String str=element.id();
        System.out.println(str);
            //2.className
            String str1=element.className();
        System.out.println(str1);
            Set<String> stringSet=element.classNames();
        System.out.println(stringSet);
            //3.attr属性的值
            String str2=element.attr( "class" );
        System.out.println(str2);
            //4.attributes
            Attributes attributes=element.attributes();
        System.out.println(attributes);
            //5.文本内容
        String str3=element.text();
        System.out.println(str3);

    }
}
