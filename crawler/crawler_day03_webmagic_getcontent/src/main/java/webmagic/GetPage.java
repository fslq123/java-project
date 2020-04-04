package webmagic;

import org.junit.Test;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;

/*获取页面*/
public class GetPage implements PageProcessor {
    //解析页面
    @Override
    public void process(Page page) {
        //解析返回的数据page,并且把解析结果放到resultItems中
        //1.css选择器
       // page.putField( "div",page.getHtml().css( "div.nav" ).all() );//多条
        //2.XPath
        page.putField( "div2",page.getHtml().xpath( "//ul[@class=mainnav-ul]/li[3]" ).toString() );//多条
        //3.正则表达式
        //page.putField( "div3",page.getHtml().xpath( "//div[@class=navwrapper]/div[@class=nav]/div/ul/li/ul/li" ).regex( ".*教育.*" ) .get());//一条
        //4.抓取链接地址
       // page.addTargetRequest( page.getHtml().xpath( "//div[@class=navwrapper]/div[@class=nav]/div/ul/li" ).links().regex( ".*edu-1.*" ).get() );//get url-1
       // page.addTargetRequest( page.getHtml().xpath( "//ul[@class=yahei]/li/ul/li" ).links().regex(  ".*edu-1-1.*") .get());//get url-1-1
        //page.putField( "本科专业", page.getHtml().xpath( "//div[@class=benKe]" ).all());//to url-1-1
    }

    private Site site=Site.me()
            .setCharset( "utf-8" )//设置编码
            .setTimeOut( 10000 )//设置超时
            .setSleepTime( 3 )//设置重试次数
            .setRetryTimes( 1000 );//设置重试间隔时间
    @Override
    public Site getSite() {
        return site;
    }
    @Test//执行爬虫
    public void fun(){
        Spider.create(new GetPage())
                .addUrl( "https://gkcx.eol.cn" )//设置爬取页面
                //.addUrl( "https://www.tsinghua.edu.cn/publish/thu2018/index.html" )//设置爬取页面
                .setScheduler( new QueueScheduler().setDuplicateRemover( new BloomFilterDuplicateRemover( 100000000 ) ) )//设置去重布隆过滤器：最多对100...数据操作
                .addPipeline( new FilePipeline( "D:\\WorkSpace\\Idea\\crawler\\crawler_day03_webmagic_getcontent\\src\\main\\resources" ) )//解析内容下载
                .thread( 5 )//多线程
                .run();//执行爬虫
    }
}
