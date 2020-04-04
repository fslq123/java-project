package com.fslq.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*
* 相当于bean.xml
* */
@Configuration//开启配置
@ComponentScan("com.fslq")//配置扫描包
@Import( {JdbcConfig.class,TransactionConfig.class} )//导入类
@PropertySource( "jdbcConfig.properties" )//导入配置文件
@EnableTransactionManagement//开启事务注解支持
public class SpringConfiguration {
}
