package com.fslq.jd.impl;

import com.fslq.jd.dao.ItemDao;
import com.fslq.jd.pojo.Item;
import com.fslq.jd.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ItemServiceImpl implements ItemService {
    //注入持久层
    @Autowired
    private ItemDao itemDao;
    @Override
    @Transactional//为保存方法开启事务
    public void save(Item item) {
        itemDao.save( item );
    }

    @Override
    public List<Item> findAll(Item item) {
        //声明查询条件
        Example<Item> example=Example.of(item);
        //根据查询条件进行查询
        List<Item> list=itemDao.findAll(example);
        return list;
    }
}
