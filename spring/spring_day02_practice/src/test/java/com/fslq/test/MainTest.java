package com.fslq.test;

import com.fslq.domain.Account;
import com.fslq.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainTest {
    ApplicationContext ac=null;
    AccountService as=null;
    @Before
    public void init(){
        //1.获取容器
        ac=new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务对象
        as=ac.getBean("accountService",AccountService.class);
    }
    @Test
    public void findAllAccountTest(){
        //3.执行方法
        List<Account> accountList=as.findAllAccount();
        accountList.stream().forEach(p->System.out.println(p));
    }
    @Test
    public void findByIdAccountTest() {
        System.out.println(as.findByIdAccount(2));
    }
    @Test
    public void saveAccountTest() {
        as.saveAccount(new Account("小明",1200f));
        findAllAccountTest();
    }
    @Test
    public void updateAccountTest() {
        as.updateAccount(new Account(4,"小红",8000f));
        findAllAccountTest();
    }
    @Test
    public void deleteByIdAccountTest() {
        as.deleteByIdAccount(2);
        findAllAccountTest();
    }
}
