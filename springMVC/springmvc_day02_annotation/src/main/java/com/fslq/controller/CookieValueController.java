package com.fslq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/*
* 用于把指定 cookie 名称的值传入控制器方法参数
* */
@Controller
@RequestMapping("cookie")
public class CookieValueController {
    @RequestMapping("cookieValue")
//    value：指定 cookie 的名称
//    required：是否必须有此 cookie
    public String cookieValue(@CookieValue(value="JSESSIONID",required=false) String cookie){
        if(cookie.isEmpty())
            return "error";
        System.out.println( cookie );
        return "success";
    }
}
