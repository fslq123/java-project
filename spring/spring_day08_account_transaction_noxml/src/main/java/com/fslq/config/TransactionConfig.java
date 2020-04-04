package com.fslq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/*
* 事务相关配置类
* */
public class TransactionConfig {
    //创建事务管理对象，放入bean容器中
    @Bean(name="transactionManager")
    public PlatformTransactionManager createTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager( dataSource );
    }
}
