package com.fslq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/*
*作用：
* 用于多次执行控制器方法间的参数共享。
* 属性：
*   value：用于指定存入的属性名称
*   type：用于指定存入的数据类型。
* */
@Controller
@RequestMapping("session")
@SessionAttributes(value={"uname","psw"},types={Integer.class})
public class SessionAttributeController {
    //存入
    @RequestMapping("put")
    public String put(Model model){
        model.addAttribute( "uname", "小明");
        model.addAttribute( "psw","123456" );
        model.addAttribute( "age",18 );
        return "success";
    }
    //获取
    @RequestMapping("get")
    public String get(Model model){
        if(model.getAttribute( "uname" )==null)
            return "error";
        return "success";
    }
    //清除
    @RequestMapping("clean")
    public String clean(SessionStatus sessionStatus){
        if(sessionStatus.isComplete())
            return "error";
        sessionStatus.setComplete();
        System.out.println( "success" );
        return "success";
    }
}
