package com.fslq.selector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/*
* 遍历
* */
public class TestHtml {
    @Test
    //选择器的基本使用
    public void testSelector() throws IOException {
        //解析文件
        Document document=Jsoup.parse( new File("D:\\WorkSpace\\Idea\\crawler\\crawler_day01_jsoup\\src\\main\\resources\\清华大学.html" ),"utf8" );
      /*  //1.根据id
        Element element=document.select( "header" ).first();
        System.out.println("根据id"+element);
        //2.根据标签
        Elements element1=document.select( "title" );
        System.out.println("根据标签"+element1);
        //3.根据class
        Element element2=document.select(".section_1" ).first();//class="section_1" ...
        System.out.println("根据class"+element2);*/
        //4.根据属性
        Elements element3=document.select( "[href]" );
        System.out.println("根据属性"+element3);
        //5.根据属性值
        Element element4=document.select( "[href=/publish/newthu/newthu_cnt/faculties/index.html]").first();
        System.out.println("根据属性值"+element4);

    }
    //选择器的组合使用
    //@Test
    public void testSelectors() throws IOException {
        //解析文件
        Document document=Jsoup.parse( new File("D:\\WorkSpace\\Idea\\crawler\\crawler_day01_jsoup\\src\\main\\resources\\清华大学.html" ),"utf8" );
        //元素+id
        System.out.println("元素+id"+document.select( "div#header" ).first());
        //元素+class
        System.out.println("元素+class"+document.select( "div.section_1" ).first());
        //元素+元素名
        System.out.println("元素+元素名"+document.select( "a[href]" ).first());
        //任意组合
        System.out.println("任意组合"+document.select( "div.section_1 fi" ));
        //查找该元素下面的子元素
        System.out.println("查找该元素下面的子元素："+document.select( "div.tlink li" ).text());
        //查找该元素下面的直接子元素
        System.out.println("查找该元素下面的直接子元素："+document.select( "div.tlink > div > ul > li > a" ).text());
    }
}
