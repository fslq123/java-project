package com.fslq.jd.dao;

import com.fslq.jd.pojo.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//持久层

public interface ItemDao extends JpaRepository<Item,Long> {

}
