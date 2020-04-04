package com.fslq.service;

import com.fslq.pojo.Job;
import com.fslq.pojo.JobInfo;
import com.fslq.pojo.JobResult;
import org.springframework.data.domain.Page;

public interface JobInfoService {
    /*ElastaticSearch*/
    void saveJobInfo(JobInfo jobInfo);
    void saveAllJobInfo(Iterable<JobInfo> jobInfos);

    /*数据库*/
    Page<Job> findByPageJob(Integer page,Integer rows);
    JobResult search(String salary,String jobarea,String keyword,Integer page);
}
