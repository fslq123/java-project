package com.fslq.config;

import com.fslq.utils.ConnectUtils;
import org.springframework.context.annotation.*;
/*
* 配置类与bean.xml功能一样*/
@Configuration
@Import({JdbcConfig.class,ConnectUtils.class})

@PropertySource("classpath:jdbcConfig.properties")
@ComponentScan(basePackages="com.fslq")//扫描包路径
public class BeanXmlConfig {
    //TO DO SOMETHING
}
