package com.fslq.test;

import com.fslq.Impl.AccountServiceImpl;
import com.fslq.domain.Account;
import com.fslq.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:bean.xml")
public class MainTest {
    @Autowired
    private AccountService as;
    @Test
    public void transferTest(){
      System.out.println( "-----------转账前--------------" );
      as.findAllAccount().stream().forEach( p->{
          System.out.println(p);
      } );
      as.transfer( "小花","小明",200f );
      System.out.println( "-----------转账后--------------" );
     as.findAllAccount().stream().forEach( p->{
         System.out.println(p);
     } );
  }
}
