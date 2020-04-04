package com.fslq.test;

import com.fslq.config.BeanXmlConfig;
import com.fslq.domain.Account;
import com.fslq.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
/*
* Junit:测试不会受spring作用
* 因此，需整合junit的配置
*       1、导入spring整合的jar（坐标）
*       2、使用Junit提供的一个注释把原有的main方法替换了，替换成spring提供的@Runwith
*       3、告知spring运行器，spring和ioc创建是基于xml或是注解的，并说明位置
*       @ContextConfiguration:
*               location:指定xml文件的位置，加上classpath关键字，表示在类路径下
*               classes：指定注解类所在的位置
* */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=BeanXmlConfig.class)
public class MainTest {
    /*自动创建ioc容器*/
    @Autowired
    AccountService as=null;
@Test
    public void findAllAccountTest(){
        //3.执行方法
        List<Account> accountList=as.findAllAccount();
        accountList.stream().forEach(p->System.out.println(p));
    }
    //@Test
  /*  public void transferAccount(){
        System.out.println("----------转账前-----------");
        findAllAccountTest();
        if(!as.transfer("小红","小明",3890f))
            System.out.println("余额不足！");
        System.out.println("----------转账后-----------");
        findAllAccountTest();
    }*/

}
