package com.fslq.task;

import com.fslq.pojo.Job;
import com.fslq.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/*
* 数据入库
* */
@Component//创建实例
public class SpringDataPipeline implements Pipeline {
    @Autowired
    private JobService jobService;
    @Override
    public void process(ResultItems resultItems,Task task) {
        //获取封装好的招聘信息对象
        Job jobInfo=resultItems.get( "jobInfo" );
        //判断
        if(jobInfo!=null){
            //不空，保存入库
            jobService.save( jobInfo );
        }
    }
}
