package com.fslq.test;

import com.fslq.pojo.Item;
import com.fslq.service.ItemService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

///配置全文检索测试
@RunWith( SpringJUnit4ClassRunner.class )//测试
@ContextConfiguration(locations="classpath:applicationContext.xml")//注入配置
public class MainTest {
    @Autowired
    private ItemService itemService;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    //创建索引和映射
    @Before
    public void create(){
        elasticsearchTemplate.createIndex( Item.class );
        elasticsearchTemplate.putMapping( Item.class );
    }
    //测试：增加
   // @Test
    public void save(){
        Item item=new Item();
        item.setId( 100 );
        item.setTitle( "Elasticsearch测试" );
        item.setContent( "增加功能" );
        itemService.saveItem(item);
    }
    //测试：修改
    @Test
    public void update(){
        Item item=new Item();
        item.setId( 100 );
        item.setTitle( "Elasticsearch测试" );
        item.setContent( "修改功能" );
        itemService.updateItem(item);
    }
    //测试：删除
    //@After
    public void delete(){
        Item item=new Item();
        item.setId( 1 );
        itemService.deleteItem(item);
    }
    //测试：增加多个
    @Test
    public void saveAll(){
        List<Item> items=new LinkedList<>();
        for (int i=0; i < 10; i++) {
            items.add(  new Item(i,"增加多个","内容"+i));
        }
        System.out.println(items);
        itemService.saveAllItem(items);
    }
    //查找多个
    @Test
    public void findAll(){
        Iterable<Item> items=itemService.findAllItem();
        items.iterator().forEachRemaining( p->{
            System.out.println(p);
        } );
    }
    //分页查询
    @Test
    public void findByPage(){
        Page<Item> pages=itemService.findByPageItem(1,5);
        pages.forEach( p->{
            System.out.println( p.toString() );
        } );
    }
    /*
    * 复杂操作
    * */
    //标题&&内容
    @Test
    public void findByTitleAndContent(){
        Iterable<Item> items=itemService.findByTitleAndContentItem("多个","内容");
        items.iterator().forEachRemaining( p->{
            System.out.println(p);
        } );
    }
    //标题||内容
   /* @Test
    public void findByTitleOrContent(){
        Iterable<Item> items=itemService.findByTitleOrContentItem("多个","1");
        items.iterator().forEachRemaining( p->{
            System.out.println(p);
        } );
    }*/
    //标题||内容&&分页
    @Test
    public void findByTitleOrContentAndPage(){
        Iterable<Item> items=itemService.findByTitleOrContentAndPageItem("多个","2",1,5);
        items.iterator().forEachRemaining( p->{
            System.out.println("*************");
            System.out.println(p);
        } );
    }
    //标题&&内容&&分页&&Id&&Scope
    @Test
    public void findByTitleAndContentAndIdBetweenPage(){
        Iterable<Item> items=itemService.findByTitleAndContentAndIdBetweenPageItem("多个","内容",2l,8l,0,4);
        items.iterator().forEachRemaining( p->{
            System.out.println("*************");
            System.out.println(p);
        } );
    }
}
