package com.fslq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
* 拦截器演示
* */
@Controller
@RequestMapping("interceptor")
public class InterceptorController {
    @RequestMapping("testInterceptor")
    public String testInterceptor(){
        System.out.println( "控制器执行" );
        return "success";
    }
}
