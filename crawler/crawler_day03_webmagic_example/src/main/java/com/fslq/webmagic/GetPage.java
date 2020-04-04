package com.fslq.webmagic;

import org.junit.Test;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/*获取页面*/
public class GetPage implements PageProcessor {

    @Override
    public void process(Page page) {
        //解析返回的数据page,并且把解析结果放到resultItems中
        page.putField( "div",page.getHtml().css( "div.nav li" ).all() );
    }

    private Site site=Site.me();
    @Override
    public Site getSite() {
        return site;
    }
    @Test//执行爬虫
    public void fun(){
        Spider.create(new GetPage())
                .addUrl( "https://www.tsinghua.edu.cn/" )//设置爬取页面
                .run();//执行爬虫
    }
}
