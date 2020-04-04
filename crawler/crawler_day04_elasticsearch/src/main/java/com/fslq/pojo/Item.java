package com.fslq.pojo;


import org.springframework.data.annotation.Id;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
//配置全文检索
@Document( indexName="item",type="item" )
public class Item {
    public Item() {
    }

    public Item(Integer id,String title,String content) {
        this.id=id;
        this.title=title;
        this.content=content;
    }

    @Id
    @Field(index=true,store=true,type=FieldType.Integer)//配置全文检索属性
    private Integer id;
    @Field(index=true,store=true,analyzer="ik_smart",searchAnalyzer="ik_smart",type=FieldType.text)
    private String title;
    @Field(index=true,store=true,analyzer="ik_smart",searchAnalyzer="ik_smart",type=FieldType.text)
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id=id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Item{"+
                "id="+id+
                ", title='"+title+'\''+
                ", content='"+content+'\''+
                '}';
    }

    public void setTitle(String title) {
        this.title=title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content=content;
    }
}
