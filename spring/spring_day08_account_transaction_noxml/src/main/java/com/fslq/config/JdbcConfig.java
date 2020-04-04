package com.fslq.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/*
* 配置数据库类
* */
public class JdbcConfig {
    @Value( "${jdbc.driver}" )
    private String driver;
    @Value( "${jdbc.url}" )
    private String url;
    @Value( "${jdbc.username}" )
    private String username;
    @Value( "${jdbc.password}" )
    private String password;
    //创建JdbcTemplate对象，放入bean容器中
    @Bean(name="jdbcTemplate")
    public JdbcTemplate createJdbcTemplate(DataSource dataSource){
        return new JdbcTemplate( dataSource );
    }
    //创建Datasource对象，放入bean容器中
    @Bean(name="dataSource")
    public DataSource createDataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName( driver );
        dataSource.setUrl( url );
        dataSource.setUsername( username );
        dataSource.setPassword( password );
        return dataSource;
    }
}
