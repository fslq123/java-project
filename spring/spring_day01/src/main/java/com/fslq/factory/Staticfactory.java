package com.fslq.factory;

import com.fslq.service.AccountService;
import com.fslq.service.impl.AccountServiceImpl;

/*
*包含于jar包中
* 模拟创建一个工厂类（无法修改）
* */
public class Staticfactory {
    public static AccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
