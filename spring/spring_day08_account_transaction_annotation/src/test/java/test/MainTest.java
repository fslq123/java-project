package test;

import com.fslq.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:bean.xml")
public class MainTest {
    @Autowired
    //@Qualifier(value="accountService")
    private AccountService as;
    @Test
    public void transferTest(){
      System.out.println( "-----------转账前--------------" );
      as.findAccountByNamePrint( "小花" );
      as.transfer( "小花","小明",200f );
      System.out.println( "-----------转账后--------------" );
      as.findAccountByNamePrint( "小花" );
  }
}
