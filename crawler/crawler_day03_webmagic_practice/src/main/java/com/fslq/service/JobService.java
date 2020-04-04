package com.fslq.service;

import com.fslq.pojo.Job;

import java.util.List;

/*
* 业务层
* */
public interface JobService {
    //保存
    void save(Job job);
    //查询
    List<Job> findAll(Job job);
}
