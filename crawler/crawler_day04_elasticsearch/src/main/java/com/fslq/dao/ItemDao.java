package com.fslq.dao;

import com.fslq.pojo.Item;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.awt.print.Pageable;

public interface ItemDao extends ElasticsearchRepository<Item, Integer>
{
    Iterable<Item> findByTitleAndContent(String title,String content);

    //Iterable<Item> findByTitleOrContent(String title,String content);
    Iterable<Item> findByTitleOrContent(String title,String content,PageRequest pageable);

    Iterable<Item> findByTitleAndContentAndIdBetween(String title,String content,Long min,Long max,PageRequest pageable);
}
