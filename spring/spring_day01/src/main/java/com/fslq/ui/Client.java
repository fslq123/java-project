package com.fslq.ui;

import com.fslq.dao.AccountDao;
import com.fslq.dao.impl.AccountDaoImpl;
import com.fslq.service.AccountService;

import com.fslq.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.logging.XMLFormatter;

public class Client {

    public static void main(String[] args) {
        /*
         * 获取spring的Ioc核心容器，并根据Id获取对象
         *
         * ApplicationContext的三个常用实现类：
         * ClassPathXmlApplicationContext:加载类路径下的配置文件
         * FileSystemXmlApplicationContext:加载磁盘任意路径下的配置文件（必须有访问权限）
         * AnnotationConfigApplicationContext:读取注解创建容器
         *
         * 问题：
         *   1.ApplicationContext:单例对象（多用)
         *       构建核心容器时采用立即加载，读完建完
         *   2.BeanFactory：多例对象
         *       ...采用延迟加载，啥时有Id啥时创建
         * */
        //ApplicationContext
        //1.获取核心容器对象
        ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象
        AccountService as=(AccountService)ac.getBean("accountService");
        AccountDao accountDao=ac.getBean("accountDao",AccountDao.class);
        System.out.println(as);
        accountDao.saveAccountDao();

        //BeanFactory
        System.out.println("*************BeanFactory************");
        Resource resource=new ClassPathResource("bean.xml");
        BeanFactory beanFactory=new XmlBeanFactory(resource);
        as=(AccountService)beanFactory.getBean("accountService");
        System.out.println(as);

        //注入bean
        System.out.println("---------注入构造函数---------");
        AccountServiceImpl asi=(AccountServiceImpl)ac.getBean("accountService");
        asi.printAccount();
        System.out.println("----------set方法注入-----------");
        AccountDaoImpl adi=(AccountDaoImpl)ac.getBean("accountDao");
        adi.printAccountDao();
        System.out.println("-----------集合注入------------");

        adi.showCollection();
        ac.close();
    }
}
