package com.fslq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//SpringBoot:开启定时任务
@SpringBootApplication
@EnableScheduling//计划表
public class Application {
    public static void main(String[] args) {
        SpringApplication.run( Application.class,args );
    }
}
