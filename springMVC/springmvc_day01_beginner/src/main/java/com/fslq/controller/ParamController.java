package com.fslq.controller;

import com.fslq.domain.Account;
import com.fslq.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
* 请求参数绑定控制器
* */
@Controller
@RequestMapping("/param")
public class ParamController {

    //传参
    @RequestMapping("/postParam")
    public String postParam(String username){
        if(username.isEmpty())
            return "error";
        return "postParam";
    }
    //保存账户信息
    @RequestMapping("saveAccount")
    public String saveAccount(Account account){
        if(account.getUsername().isEmpty() )
            return "listmapParam";
        System.out.println( "姓名："+account.getUsername() );
        System.out.println( "密码："+account.getPassword() );
        System.out.println( "金额："+account.getMoney() );
        System.out.println( "用户姓名："+account.getUser().getUname() );
        System.out.println( "用户年龄："+account.getUser().getAge() );
        return "postParam";
    }
    //传递实体集合
    @RequestMapping("listMapPerson")
    public String listMapPerson(Person person){
        if(person.getUsername().isEmpty())
            return "error";
        System.out.println( person );
        return "postParam";
    }
}
