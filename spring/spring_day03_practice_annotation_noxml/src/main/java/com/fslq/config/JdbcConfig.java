package com.fslq.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

public class JdbcConfig {
    //加载jdbc配置文件
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    /*
     * 创建QueryRunner对象
     * */
    @Bean(name="queryRunner")//存储到名为queryRunner的spring ioc容器中
    @Scope(value="prototype")
    public QueryRunner createQueryRunner(@Qualifier("dateSource_e") DataSource dateSource){//dataSource会自动从IoC容器中查找,在没有dateSource
        return new QueryRunner(dateSource);                                                 //时查找dateSource_e
    }
    /*
     * 创建数据源对象
     * */
    @Bean(name="dateSource")//放入IOC容器
    public DataSource createDataSource(){
        try {
            ComboPooledDataSource ds=new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(username);
            ds.setPassword(password);
            return ds;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    @Bean(name="dateSource_e")//放入IOC容器
    public DataSource createDataSource_e(){
        try {
            ComboPooledDataSource ds=new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/spring_exmple");
            ds.setUser(username);
            ds.setPassword(password);
            return ds;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
