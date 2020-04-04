package fslq.jdbcTemplate;


import com.fslq.domain.Account;
import com.fslq.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/*
* jdbcTemplate的基本用法
* */
public class JdbcTemplateDemo1 {
    @Test
    public void jdbcTemplateBeanXmlTest(){
        //1.获取容器
        ApplicationContext ac=new ClassPathXmlApplicationContext( "bean.xml" );
        //2.获取对象
        AccountService as=(AccountService)ac.getBean( "accountService" );
        as.findAccountByNamePrint( "小明" );
        as.updateAccountOperate( new Account( 4,"小花",6000f ) );
        as.findAccountByIdPrint( 4 );

    }
}
