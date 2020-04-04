package com.fslq;

import com.fslq.dao.JobInfoDao;
import com.fslq.pojo.Job;
import com.fslq.pojo.JobInfo;
import com.fslq.service.JobInfoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.LinkedList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class MainTest {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    private JobInfoService jobInfoService;
    @Before
    public void start(){
        elasticsearchTemplate.createIndex( JobInfo.class );
        elasticsearchTemplate.putMapping( JobInfo.class );
    }
    @Test//从数据库中获取数据，并放入索引框
    public void getSqlData(){
        int page=0;
        int page_size=0;
        do {
            //1.从数据库中查询数据
            Page<Job> jobs=jobInfoService.findByPageJob(page++,500);
            //2.Job封装到JobInfo中
            List<JobInfo> jobInfos=new LinkedList <>();
            jobs.iterator().forEachRemaining( p->{
                JobInfo jobInfo=new JobInfo();
                //封装
                BeanUtils.copyProperties( p,jobInfo );
                //添加
                jobInfos.add( jobInfo );
            } );
            //3.传入索引库
            jobInfoService.saveAllJobInfo( jobInfos );
            page_size=jobInfos.size();
        }while (page_size<=0);
    }
}
