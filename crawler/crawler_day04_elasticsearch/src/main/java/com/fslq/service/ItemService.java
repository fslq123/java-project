package com.fslq.service;

import com.fslq.pojo.Item;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ItemService {
    Iterable<Item> findAllItem();

    void saveItem(Item item);

    void updateItem(Item item);

    void deleteItem(Item item);

    void saveAllItem(List<Item> items);

    Page<Item> findByPageItem(int i,int i1);

    Iterable<Item> findByTitleAndContentItem(String title,String content);

    //Iterable<Item> findByTitleOrContentItem(String title,String content);

    Iterable<Item> findByTitleOrContentAndPageItem(String title,String content,int page,int rows);

    Iterable<Item> findByTitleAndContentAndIdBetweenPageItem(String title,String content,Long min,Long max,Integer page,Integer rows);
}
