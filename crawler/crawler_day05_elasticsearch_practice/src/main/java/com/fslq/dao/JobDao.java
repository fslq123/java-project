package com.fslq.dao;

import com.fslq.pojo.Job;
import org.springframework.data.jpa.repository.JpaRepository;

//数据库持久层接口
public interface JobDao extends JpaRepository<Job,Long> {
}
