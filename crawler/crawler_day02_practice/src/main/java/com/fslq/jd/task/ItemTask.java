package com.fslq.jd.task;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fslq.jd.impl.ItemServiceImpl;
import com.fslq.jd.pojo.Item;
import com.fslq.jd.service.ItemService;
import com.fslq.jd.utils.HttpUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Date;


/*实现定时任务
* */
@Component
public class ItemTask {
    @Autowired
    private HttpUtils httpUtils;//获取页面内容
    @Autowired
    private ItemService itemService;
    public static final ObjectMapper MAPPER=new ObjectMapper(  );//解析json数据


    //任务启动间隔计划
    @Scheduled(fixedDelay=100*1000)//100s
    public void itemTask() throws Exception{
        String url="https://list.jd.com/list.html?cat=9987,653,655&page=";
        String url_t="&sort=sort_rank_asc&trans=1&JL=6_0_0#J_main";
        //解析前5页
        for (int i=1; i <6 ; i++) {
            String html=this.httpUtils.doGetHtml( url+i+url_t );
           // System.out.println("网站："+html);
            this.parse(html);
        }
    }
    //解析页面内容并存储
    private void parse(String html) {

        //解析html
        Document document=Jsoup.parse( html );
        //获取data-i到spu中
        Elements spuEles=document.select( "div.g-main2>div>div div#plist>ul li.gl-item" );
        System.out.println("spuEles:"+spuEles.first());
        System.out.println( "*******"+spuEles.select( "div[jdzy_shop_id]" ) .attr( "jdzy_shop_id" ));
        spuEles.stream().forEach( p->{
            Item item=new Item();
            //存spu
            item.setSpu( Long.parseLong( p.select( "div[jdzy_shop_id]" ) .attr( "jdzy_shop_id" )) );
            //item.setPrice(Double.parseDouble( ( p.select( "div.p-price>strong.J_price i" ).text() )  ));
            //存入sku
            item.setSku(Long.parseLong(  p.select( "li.ps-item>a>img[data-sku]" ).attr( "data-sku" ) ));
            //存入url
            item.setUrl( "https://item.jd.com/"+item.getSku()+".html" );

            //存入价格
            String priceJson=httpUtils.doGetHtml( "https://p.3.cn/prices/mgets?skuids=J_"+item.getSku() );
            try{
                final double price=MAPPER.readTree( priceJson ).get( 0 ).get( "p" ).asDouble();
                item.setPrice( price );
            }catch(JsonProcessingException e){
                e.printStackTrace();
            }
            //存title
            String itemInfo=httpUtils.doGetHtml( item.getUrl() );
            String title=Jsoup.parse( itemInfo ).select( "div.sku-name" ).text();
            System.out.println(title);
            item.setTitle(title);

            //时间
            item.setCreated( new Date( ) );
            item.setUpdated( item.getCreated() );

            //存入图片
            String picurl="https:"+p.select( "img[src]" ).attr( "src" );
            picurl=picurl.replace( "/n7/","/n1/" ).replace( "/n9/","/n1/" );
            String picName=null;
            picName=this.httpUtils.doGetImage( picurl );
            item.setPic( picName );
            //保存到数据库中
            System.out.println(item);
            this.itemService.save( item );
        } );
    }
}
