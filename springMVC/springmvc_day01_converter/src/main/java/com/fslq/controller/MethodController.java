package com.fslq.controller;

import com.fslq.domain.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
* 控制器类
* */
@Controller
@RequestMapping("user")
public class MethodController {
    //保存用户信息
    @RequestMapping("saveUser")
    public String saveUser(User user){
        if(user.getUsername().isEmpty())
            return "error";
        System.out.println(user);
        return "success";
    }

    //获取原生API

//    public String testServlet(HttpServletRequest request,HttpServletResponse response){
//        System.out.println( "演示中" );
//
//    }
}
