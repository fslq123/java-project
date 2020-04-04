package com.fslq.impl;

import com.fslq.dao.JobDao;
import com.fslq.pojo.Job;
import com.fslq.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobDao jobDao;
    @Override
    @Transactional
    public void save(Job job) {
        //判断数据库中是否已存在此数据
        //查询原有数据
        //根据分布时间和url
        Job job_temp=new Job();
        job_temp.setUrl( job.getUrl() );
        job_temp.setTime( job.getTime() );
        //组合条件查询
        List<Job> list=findAll( job_temp );
        //判断
        if(list.size()==0)
            jobDao.save( job );
    }

    @Override
    public List<Job> findAll(Job job) {
        //设置查询条件
        Example example=Example.of(job);
        return jobDao.findAll(example);
    }
}
