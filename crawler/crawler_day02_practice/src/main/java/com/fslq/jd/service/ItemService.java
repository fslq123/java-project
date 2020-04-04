package com.fslq.jd.service;

import com.fslq.jd.pojo.Item;
import org.springframework.stereotype.Service;

import java.util.List;

//业务层

public interface ItemService {
    //保存商品
    void save(Item item);
    //根据条件查询商品
    List<Item> findAll(Item item);
}
