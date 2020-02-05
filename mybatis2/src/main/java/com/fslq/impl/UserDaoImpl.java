package com.fslq.impl;

import com.fslq.dao.UserDao;
import com.fslq.domain.QueryVo;
import com.fslq.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
/*使用类实现，而非Mybatis*/
import java.util.List;

public class UserDaoImpl implements UserDao {
    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory=factory;
    }

    @Override
    public List<User> findAll() {
        System.out.println("Impl方法");
        //1.根据factory获取SqlSession对象
        SqlSession session=factory.openSession();
        //2.调用SqlSession中的方法，实现查询列表
        List<User> users=session.selectList("com.fslq.dao.UserDao.findAll");
        session.close();
        return users;
    }

    @Override
    public void saveUser(User user) {
        //1.根据factory获取SqlSession对象
        SqlSession session=factory.openSession();
        //2.调用SqlSession中的方法
        session.insert("com.fslq.dao.UserDao.saveUser",user);
        //3.提交事务
        session.commit();
        session.close();
    }

    @Override
    public void updateUser(User user) {
        //1.根据factory获取SqlSession对象
        SqlSession session=factory.openSession();
        //2.调用SqlSession中的方法
        session.update("com.fslq.dao.UserDao.updateUser",user);
        //3.提交事务
        session.commit();
        session.close();
    }

    @Override
    public void deleteUserById(int id) {
        //1.根据factory获取SqlSession对象
        SqlSession session=factory.openSession();
        //2.调用SqlSession中的方法
        session.delete("com.fslq.dao.UserDao.deleteUserById",id);
        //3.提交事务
        session.commit();
        session.close();
    }

    @Override
    public User findById(int id) {
        //1.根据factory获取SqlSession对象
        SqlSession session=factory.openSession();
        //2.调用SqlSession中的方法
        User user=session.selectOne("com.fslq.dao.UserDao.findById",id);
        //3.提交事务
        session.commit();
        session.close();
        return user;
    }

    @Override
    public List<User> findByName(String username) {
        //1.根据factory获取SqlSession对象
        SqlSession session=factory.openSession();
        //2.调用SqlSession中的方法
        List<User> users=session.selectList("com.fslq.dao.UserDao.findByName","%"+username+"%");
        //3.提交事务
        session.commit();
        session.close();
        return users;
    }

    @Override
    public int findTotal() {
        //1.根据factory获取SqlSession对象
        SqlSession session=factory.openSession();
        //2.调用SqlSession中的方法
        int total=session.selectOne("com.fslq.dao.UserDao.findTotal");
        //3.提交事务
        session.commit();
        session.close();
        return total;
    }

    @Override
    public List<User> findByQueryVo(QueryVo vo) {
        //1.根据factory获取SqlSession对象
        SqlSession session=factory.openSession();
        //2.调用SqlSession中的方法
        List<User> users=session.selectList("com.fslq.dao.UserDao.findByName","%"+vo.getUser().getUsername()+"%");
        //3.提交事务
        session.commit();
        session.close();
        return users;
    }
}
