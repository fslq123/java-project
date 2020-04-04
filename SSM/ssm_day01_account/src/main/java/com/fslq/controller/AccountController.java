package com.fslq.controller;

import com.fslq.domain.Account;
import com.fslq.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/*
* 前端控制器
* */
@Controller
@RequestMapping("account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @RequestMapping("findAll")
    public String findAll(Model model){
        System.out.println( "方法执行" );
        List<Account> accounts=accountService.findAllAccount();
        model.addAttribute( "accounts",accounts );
        return "list";
    }
    @RequestMapping("save")
    public String save(Account account){
        accountService.saveAccount( account );
        System.out.println("保存成功");
        //跳转
        return "redirect:findAll";
    }
}
