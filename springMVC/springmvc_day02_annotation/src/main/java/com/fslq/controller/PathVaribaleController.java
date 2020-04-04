package com.fslq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/*
* 规范编程风格（restful),以获得参数
* */
@Controller
@RequestMapping("rest")
public class PathVaribaleController {
    @RequestMapping("pathVaribale/{sid}")
    public String pathVaribale(@PathVariable(name="sid") String id){
        if(id.isEmpty())
            return "error";
        System.out.println("id:"+id);
        return "success";
    }
}
