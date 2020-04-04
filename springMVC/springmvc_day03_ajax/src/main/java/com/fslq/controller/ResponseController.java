package com.fslq.controller;


import com.fslq.domain.User;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/*
* 响应
* */
@Controller
@RequestMapping("user")
public class ResponseController {

    //Ajax实现动态json数据跳转
    @RequestMapping(value="ajax")
    public @ResponseBody User testAjax(@RequestParam Map<String,String> body){//@RequestBody User user 不能使用
        //客户端发送ajax请求，传递json字符串，后端把json字符串封装到user中
        User user=new User(body.get( "uname" ),Integer.parseInt(body.get( "age" )));//<==>@RequestBody User user
        System.out.println( "Ajax执行中");
        return user;
    }
}
