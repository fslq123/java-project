package com.fslq.impl;

import com.fslq.dao.ItemDao;
import com.fslq.pojo.Item;
import com.fslq.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class ItemServiceImpl implements ItemService {
   @Autowired
    private  ItemDao itemDao;

    @Override
    public Iterable<Item> findAllItem() {
        return  itemDao.findAll();
    }

    @Override
    public void saveItem(Item item) {
        itemDao.save( item );
    }

    @Override
    public void updateItem(Item item) {
        itemDao.save( item );
    }

    @Override
    public void deleteItem(Item item) {
        itemDao.deleteById( item.getId() );
    }
    @Override
    public void saveAllItem(List<Item> items) {
        itemDao.saveAll( items );
    }

    @Override
    public Page<Item> findByPageItem(int page,int rows) {
        return itemDao.findAll( PageRequest.of(page,rows));
    }

    @Override
    public Iterable<Item> findByTitleAndContentItem(String title,String content) {
        return itemDao.findByTitleAndContent(title,content);
    }

    /*@Override
    public Iterable<Item> findByTitleOrContentItem(String title,String content) {
        return itemDao.findByTitleOrContent( title,content );
    }*/

    @Override
    public Iterable<Item> findByTitleOrContentAndPageItem(String title,String content,int page,int rows) {
        return itemDao.findByTitleOrContent(title,content,PageRequest.of( page,rows ));
    }

    @Override
    public Iterable<Item> findByTitleAndContentAndIdBetweenPageItem(String title,String content,Long min,Long max,Integer page,Integer rows) {
        return itemDao.findByTitleAndContentAndIdBetween(title,content,min,max,PageRequest.of( page,rows ));
    }
}
