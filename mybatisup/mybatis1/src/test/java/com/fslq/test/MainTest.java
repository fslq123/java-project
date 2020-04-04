package com.fslq.test;

import com.fslq.dao.AccountDao;
import com.fslq.dao.RoleDao;
import com.fslq.dao.UserDao;
import com.fslq.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MainTest {
    private InputStream is;
    private SqlSession session;

    /*实例化*/
    private UserDao userDao;
    private AccountDao accountDao;
    private RoleDao roleDao;
    @Before//用于在测试方法之前执行
    public void init()throws IOException {
        //1.读取配置文件
        is=Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=sqlSessionFactoryBuilder.build(is);
        //3.生产SqlSession对象
        session=factory.openSession();
        //4.实现UserDao接口
        userDao=session.getMapper(UserDao.class);
        accountDao=session.getMapper(AccountDao.class);
        roleDao=session.getMapper(RoleDao.class);
    }
    @After//用于在测试方法之后执行
    public void destroy() throws Exception {
            session.commit();
            //6.释放资源
            session.close();
            is.close();
    }
    /*查找所有*/
   @Test
    public void findAllUserTest(){
        //5.执行接口方法
        userDao.findAll().stream().forEach(person->{
            System.out.println(person);
        });
    }
    //@Test
    public void findByIdAccount(){
        accountDao.findById(41).stream().forEach(p->System.out.println(p));
    }
   // @Test
    public void findAllAccountTest(){
        System.out.println("账户：");
        accountDao.findAll().stream().forEach(account ->System.out.println(account));
    }
    //@Test
    public void findRoleAndUserMapTest(){
        System.out.println("角色");
        roleDao.findRoleAndUserMap().stream().forEach(ru->System.out.println(ru+ru.getUserList().toString()));
    }

    //@Test
    public void findByIdUserTest(){

        System.out.println(userDao.findById(53));
    }

    /*一对一映射查询*/
    //@Test
    public void findAccountUserAllTest(){
        accountDao.findAccountUserAll().stream().forEach(accountUser ->System.out.println(accountUser));
    }


   // @Test
    public void findAccountUserMapTest(){
        accountDao.findAccountUserMap().stream().forEach(am->{
            System.out.print(am);
            System.out.println(am.getUser());
        });
    }

    /*一对多映射查询*/
    //@Test
    public void findUserAccountMapTest(){
        userDao.findUserAccountMap().stream().forEach(p->{
            System.out.println(p);
            //System.out.println(p.getAccountList());
        });
    }



}
