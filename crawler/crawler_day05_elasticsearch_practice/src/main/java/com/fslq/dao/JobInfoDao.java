package com.fslq.dao;

import com.fslq.pojo.JobInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

//继承ElasticsearchRepository
@Repository
public interface JobInfoDao extends ElasticsearchRepository<JobInfo,Long> {
    Page<JobInfo> findBySalaryMinBetweenAndSalaryMaxBetweenAndJobAddrAndJobName(
            Integer salary_min,Integer salary_max,Integer salary_min1,Integer salary_max1,String jobaddr,String keyword,Pageable pageable);
}
