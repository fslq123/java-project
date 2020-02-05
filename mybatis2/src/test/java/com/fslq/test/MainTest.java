package com.fslq.test;

import com.fslq.dao.UserDao;
import com.fslq.domain.QueryVo;
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
import java.util.Date;
import java.util.stream.Stream;

public class MainTest {
    private InputStream is;
    private SqlSession session;
    private UserDao userDao;
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
    }
    @After//用于在测试方法之后执行
    public void destroy() throws Exception {
            session.commit();
            //6.释放资源
            session.close();
            is.close();
    }
    /*查找所有*/
   // @Test
    public void findAllTest(){
        //5.执行接口方法
        userDao.findAll().stream().forEach(person->{
            System.out.println(person);
        });
    }
    /*保存用户*/
   // @Test
    public void saveUserTest(){
        User user=new User(null,"Xunker",new Date(),"男","安徽淮南");
        userDao.saveUser(user);
    }
    /*更新用户*/
    //@Test
    public void updateUserTest(){
        User user=new User(48,"风随浪起",new Date(),"男","安徽淮南");
        userDao.updateUser(user);
    }
    /*删除用户*/
   // @Test
    public void deleteUserByIdTest(){
        userDao.deleteUserById(51);
    }
    /*根据id查询用户*/
   // @Test
    public void findByIdTest(){
        System.out.println(userDao.findById(53));
    }
    /*根据姓名模糊查询用户*/
    @Test
    public void findByNameTest(){
        userDao.findByName("%风%").stream().forEach(person->{
            System.out.println(person);
        });
    }
    @Test
    public void findByQueryVoTest(){
        QueryVo queryVo=new QueryVo(new User());
        queryVo.getUser().setUsername("%X%");
        userDao.findByQueryVo(queryVo).stream().forEach(person->{
            System.out.println(person);
        });
    }
    /*统计用户数*/
    @Test
    public void findTotalTest(){
        System.out.println(userDao.findTotal());
    }
}
