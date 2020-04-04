package com.fslq.test;

import com.fslq.domain.Account;
import com.fslq.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:bean.xml")
public class MainTest {
    @Autowired
    AccountService as=null;

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
