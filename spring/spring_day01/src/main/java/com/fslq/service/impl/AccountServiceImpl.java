package com.fslq.service.impl;

import com.fslq.dao.AccountDao;
import com.fslq.dao.impl.AccountDaoImpl;
import com.fslq.service.AccountService;

import java.util.Date;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao=new AccountDaoImpl();//耦合

    /*演示注入*/
    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(String name,Integer age,Date birthday) {
        this.name=name;
        this.age=age;
        this.birthday=birthday;
    }
    public void printAccount(){
        System.out.println("账户信息:"+name + age + birthday);
    }

    public AccountServiceImpl() {
        System.out.println("AccountService对象创建了");
    }

    public void saveAccount() {
        accountDao.saveAccountDao();
    }

    @Override
    public void printAccountService() {
        System.out.println("打印AccountService");
    }

    @Override
    public void init() {
        System.out.println("对象出生");
    }

    @Override
    public void destroy() {
        System.out.println("对象销毁");
    }
}
