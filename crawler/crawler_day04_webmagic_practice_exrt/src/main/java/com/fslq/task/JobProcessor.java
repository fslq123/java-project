package com.fslq.task;


import com.fslq.pojo.Job;
import com.fslq.service.JobService;
import com.fslq.utils.MathSalary;
import com.fslq.utils.StringToList;
import org.jsoup.helper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;


import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.proxy.SimpleProxyProvider;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;
import java.util.List;

//任务
@Component
public class JobProcessor implements PageProcessor {
    @Autowired
    private JobService jobService;
    @Autowired
    private SpringDataPipeline springDataPipeline;
    @Scheduled(cron="0 0/1 * * * ?")//定时任务函数不该有参数
    public void fun() {
        String url="https://search.51job.com/list/000000,000000,0100,01%252C32,9,99,%2B,2,5.html?lang=c&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&ord_field=0&dibiaoid=0&line=&welfare=";
        //设置代理
        //创建下载器
        HttpClientDownloader httpClientDownloader=new HttpClientDownloader();
        //设置代理服务器信息
        httpClientDownloader.setProxyProvider( SimpleProxyProvider.from(new Proxy("118.78.196.142",8118)) );
        Spider.create( new JobProcessor() )
                .addUrl(url )
                .setScheduler( new QueueScheduler().setDuplicateRemover( new BloomFilterDuplicateRemover( 1000000 ) ) )
                .setDownloader( httpClientDownloader )//设置下载信息
                .thread(100)
               .addPipeline( springDataPipeline )//数据入库
                .run();
    }

    private Site site=Site.me()
            .setCharset( "gbk" )
            .setTimeOut( 10000 )
            .setRetryTimes( 3 )
            .setSleepTime( 3000 );

    @Override
    public void process(Page page) {
        List<Selectable> list=page.getHtml().xpath( "//div[@class=dw_table]/div[@class=el and @class!='el title']" ).nodes();
        if(list.size()==0)//判断取到集合是否为空
        {
            //为空，为公司详细页面，保存
            saveInfo(page);
        }else {
            //获取公司链接
            list.stream().forEach( p->{
                //放入跳转任务队列中
                page.addTargetRequest( p.links() .get());
            } );
            //获取 ’下一页‘ url
            page.addTargetRequest( page.getHtml().xpath( "//div[@class=p_in]/ul/li[@class=bk]" ).links().get() );

        }
    }
    //解析页面，保存数据
    private void saveInfo(Page page) {
        //创建对象
        Job job=new Job();
        //获取页面
        Html html=page.getHtml();
        //封装数据
        job.setUrl( html.xpath( "//p[@class=cname]/a" ).links().get() );
        job.setCompanyInfo(html.xpath( "//div[@class='tBorderTop_box']/div[@class='tmsg inbox']/text()" ) .toString() );
        job.setCompanyName( html.xpath( "//p[@class=cname]/a/text()" ).toString() );
        job.setJobAddr( html.xpath( "//div[@class='bmsg inbox']/p[@class=fp]/text()" ).toString() );
        job.setJobInfo( html.xpath( "//div[@class='bmsg job_msg inbox']//p/text()" ).all().toString() );
        job.setJobName(  html.xpath( "//div[@class=cn]/h1/text()" ).toString());
        //获取薪资
        Integer[] salarys=MathSalary.getSalary( html.xpath( "//div[@class=cn]/strong/text()" ).toString() );
        job.setSalaryMin( salarys[0] );
        job.setSalaryMax( salarys[1] );
        String time=html.xpath( "//p[@class='msg ltype']/text()" ).toString();
        job.setTime( StringToList.fun( time )[4] );
        job.setCompanyAddr( StringToList.fun( time )[0] );
        //保存信息
        page.putField( "jobInfo",job );
    }

    @Override
    public Site getSite() {
        return site;
    }
}
