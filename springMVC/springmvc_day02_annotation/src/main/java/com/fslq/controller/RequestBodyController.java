package com.fslq.controller;

import com.fslq.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/*
* 用于获得请求体内容
* */
@Controller
@RequestMapping("body")
public class RequestBodyController {
    @RequestMapping("requestBody")
    public String requestBody(@RequestBody String body){
        if(body.isEmpty())
            return "error";
        System.out.println( body );
        return "success";
    }
}
