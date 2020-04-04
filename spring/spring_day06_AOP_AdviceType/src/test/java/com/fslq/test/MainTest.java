package com.fslq.test;

import com.fslq.service.AccountService;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
    @Test
    public void AOPTest(){
        //1.获取容器
        ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext( "bean.xml" );
        //2.获取对象
        AccountService as=(AccountService)ac.getBean( "accountService" );
        //3.执行方法
        as.saveAccount();
        as.deleteAccount();
        as.updateAccount( 1 );
    }
}
