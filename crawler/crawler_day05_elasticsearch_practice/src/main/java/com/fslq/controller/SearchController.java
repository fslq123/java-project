package com.fslq.controller;

import com.fslq.pojo.JobResult;
import com.fslq.service.JobInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
* 后端控制器
* */
@RestController
public class SearchController {
    /**
     * salary: *-*
     * page: 1
     * keyword: Java
     * jobarea:
     * Request URL: http://localhost:63342/search
     * Request Method: POST
     */
    @Autowired
    private JobInfoService jobInfoService;
    @RequestMapping(value="search",method=RequestMethod.POST)//分页查询
    public JobResult search(String salary,String jobarea,String keyword,Integer page){
        JobResult jobResult=jobInfoService.search(salary,jobarea,keyword,page);
        System.out.println("在这");
        return jobResult;
    }
}
