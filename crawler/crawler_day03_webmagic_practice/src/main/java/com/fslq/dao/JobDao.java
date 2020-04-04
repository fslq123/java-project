package com.fslq.dao;

import com.fslq.pojo.Job;
import org.springframework.data.jpa.repository.JpaRepository;

/*
* 持久层
* */
public interface JobDao extends JpaRepository<Job,Long> {
}
