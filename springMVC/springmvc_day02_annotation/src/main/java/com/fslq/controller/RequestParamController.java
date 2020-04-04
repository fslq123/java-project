package com.fslq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
* 请求参数注释控制器
* */
@Controller
@RequestMapping("param")
public class RequestParamController {
    @RequestMapping("requestParam")
    public String requestParam(@RequestParam(name="name") String username){//name->username
        if("fslq".equals( username ))
            return "success";
        return "error";
    }
}
