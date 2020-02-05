package com.fslq.test;

import com.fslq.dao.UserDao;
import com.fslq.domain.QueryVo;
import com.fslq.domain.User;
import com.fslq.impl.UserDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class MainImplTest {
    private InputStream is;
    private UserDao userDao;
    @Before
    public void init() throws IOException {
        is=Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        userDao=new UserDaoImpl(factory);
    }
    @After
    public void destroy() throws IOException {
        is.close();
    }
    //@Test
    public void findAllTest(){
        userDao.findAll().stream().forEach(p->System.out.println(p));
    }
    //@Test
    public void saveUserTest(){
        User user=new User(null,"三上悠亚",new Date(),"女","日本");
        userDao.saveUser(user);
    }
    //@Test
    public void updateUserTest(){
        User user=new User(53,"一本道",new Date(),"女","日本");
        userDao.updateUser(user);
    }
    //@Test
    public void deleteUserByIdTest(){
        userDao.deleteUserById(54);
    }
    //@Test
    public void findByIdTest(){
        System.out.println(userDao.findById(55));
    }
    //@Test
    public void findByNameTest(){
        userDao.findByName("X").stream().forEach(p->System.out.println(p));
    }
    //@Test
    public void findTotalTest(){
        System.out.println(userDao.findTotal());
    }
    @Test
    public void findByQueryVoTest(){
        QueryVo queryVo=new QueryVo(new User());
        queryVo.getUser().setUsername("王");
        userDao.findByQueryVo(queryVo).stream().forEach(p->System.out.println(p));
    }
}
