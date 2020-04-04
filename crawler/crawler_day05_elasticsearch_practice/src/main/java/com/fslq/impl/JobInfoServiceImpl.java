package com.fslq.impl;

import com.fslq.dao.JobDao;
import com.fslq.dao.JobInfoDao;
import com.fslq.pojo.Job;
import com.fslq.pojo.JobInfo;
import com.fslq.pojo.JobResult;
import com.fslq.service.JobInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class JobInfoServiceImpl implements JobInfoService {
    @Autowired
    private JobInfoDao jobInfoDao;
    @Autowired
    private JobDao jobDao;
    /*ElastaticSearch*/
    public void saveJobInfo(JobInfo jobInfo) {
        jobInfoDao.save( jobInfo );
    }

    public void saveAllJobInfo(Iterable<JobInfo> jobInfos) {
        jobInfoDao.saveAll( jobInfos );
    }
    /*数据库*/
    @Override
    public Page<Job> findByPageJob(Integer page,Integer rows) {
        return jobDao.findAll( PageRequest.of( page,rows ) );
    }

    /**
     * 从索引框中检索，并返回值
     * @param salary
     * @param jobarea
     * @param keyword
     * @param page
     * @return
     */
    @Override
    public JobResult search(String salary,String jobarea,String keyword,Integer page) {
        //薪资范围分类
        String[] salaries=salary.split( "-" );
        Integer salary_min=0,salary_max=0;
        if("*".equals( salaries[0])&&"*".equals( salaries[1] )){
            salary_min=0;
            salary_max=1000000;
        }
        if("*".equals( salaries[0])&&!"*".equals( salaries[1] )){
            salary_min=0;
            salary_max=Integer.parseInt( salaries[1])*10000;
        }
        if(!"*".equals( salaries[0])&&!"*".equals( salaries[1] )){
            salary_min=Integer.parseInt( salaries[0])*10000;
            salary_max=Integer.parseInt( salaries[1])*10000;
        }
        if(!"*".equals( salaries[0])&&"*".equals( salaries[1] )){
            salary_min=Integer.parseInt( salaries[0])*10000;
            salary_max=1000000;
        }
        //地点判断
        if(StringUtils.isEmpty( keyword ))
            keyword="*";
        //调用方法执行查询
        Page<JobInfo> jobInfoPages=jobInfoDao.findBySalaryMinBetweenAndSalaryMaxBetweenAndJobAddrAndJobName(
                salary_min,salary_max,salary_min,salary_max,jobarea,keyword,PageRequest.of( page-1,30 ));
        //封装结果集对象
        JobResult jobResult=new JobResult();
        jobResult.setPageTotal( jobInfoPages.getTotalPages() );
        jobResult.setRows( jobInfoPages.getContent() );
        return jobResult;
    }
}
