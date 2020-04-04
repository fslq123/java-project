package com.fslq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
* 控制器类：接受请求*/
@Controller("helloController")

public class HelloController {
    @RequestMapping(path="hello")//获得请求映射:配置请求路径  index.jsp->...->success.jsp
    public String sayHello(){
        System.out.println( "你好！" );
        return  "success";
    }
    @RequestMapping(value="test",method={RequestMethod.POST},params={"username=fslq"})
    public String isTest(){
        return "test";
    }
}
