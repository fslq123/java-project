package com.fslq.test;


import com.fslq.domain.User;
import com.fslq.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) throws IOException {

    //1.读取配置文件
        InputStream is=Resources.getResourceAsStream("SqlMapConfig.xml");
    //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=sqlSessionFactoryBuilder.build(is);
    //3.使用工厂生产SqlSession对象
        SqlSession session=factory.openSession();
    //4.使用SqlSession创建Dao接口的代理对象
        UserDao userDao=session.getMapper(UserDao.class);
    //5.使用代理对象执行方法
        List<User> userList=userDao.findAll();
        for (User user : userList) {
            System.out.print("姓名：");
            System.out.println(user.getUsername());
        }
    //6.释放资源
        session.close();
        is.close();
    }
}
