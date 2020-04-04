package com.fslq.test;

import com.fslq.dao.AccountDao;
import com.fslq.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring.xml"})
public class Maintest {
    //@Test
    public void findAllTest(){
        ApplicationContext ac=new ClassPathXmlApplicationContext( "spring.xml" );
        AccountDao ad=(AccountDao)ac.getBean( "accountDao" );
        AccountService as=(AccountService)ac.getBean( "accountService" );
        ad.findAll();
        as.findAllAccount();
    }
//    @Test
//    public void findAllMybatis() throws IOException {
//        //加载配置文件
//        InputStream inputStream=Resources.getResourceAsStream("mybatis.xml");
//        //创建SqlSessionFactory对象
//        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build( inputStream );
//        //创建SqlSession对象
//        SqlSession session=factory.openSession();
//        //获取代理对象
//        AccountDao accountDao=session.getMapper( AccountDao.class );
//        //查询所有数据
//        accountDao.findAll().stream().forEach( p->System.out.println(p) );
//        //关闭资源
//        session.close();
//        inputStream.close();
//    }
   /* @Before
    public void updateMybatis() throws IOException {
        //加载配置文件
        InputStream inputStream=Resources.getResourceAsStream("mybatis.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build( inputStream );
        //创建SqlSession对象
        SqlSession session=factory.openSession();
        //获取代理对象
        AccountDao accountDao=session.getMapper( AccountDao.class );
        //查询所有数据
        accountDao.update(new Account (1,"赵氏",5000d));
        //关闭资源
        session.commit();
        session.close();
        inputStream.close();
    }*/
    @Autowired
    AccountService accountService=null;
   @Test//spring\mybatis整合之后
    public void fun(){
       System.out.println("spring\\mybatis整合之后");
       accountService.findAllAccount();
   }
}
