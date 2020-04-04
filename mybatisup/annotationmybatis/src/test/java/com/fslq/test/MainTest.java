package com.fslq.test;

import com.fslq.dao.AccountDao;
import com.fslq.dao.UserDao;
import com.fslq.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class MainTest {
    @Test
    public void findAllTest() throws IOException {
        //1.输入流
        InputStream is=Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.构建SqlSessionFactory
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        //生产SqlSession
        SqlSession session=factory.openSession();
        //4.使用SqlSession获取Dao的代理对象
        UserDao userDao=session.getMapper(UserDao.class);
        AccountDao accountDao=session.getMapper(AccountDao.class);
        //5.打印/插入/删除/修改
        Date date=new Date();
        userDao.insertUser(new User(null,"小孙","女","淮南",date));
        session.commit();
        userDao.deleteUser("小孙");
        userDao.updateUser(new User(45,"小孙","女","淮南",date));
        //userDao.findAll().stream().forEach(p->System.out.println(p));
        System.out.println("查找用户为："+userDao.findById(45));
        //多对一关系映射
        accountDao.findAll().stream().forEach(p->System.out.println("账户与用户："+p));
        //一对多关系映射
        userDao.findAll().stream().forEach(p->{
            System.out.println(p);
            //System.out.println(p.getAccountList());
        });

        //6.释放资源

        session.close();
        is.close();
    }
}
