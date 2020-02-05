package com.fslq.dao;

import com.fslq.domain.QueryVo;
import com.fslq.domain.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public interface UserDao {
    List<User> findAll();
    void saveUser(User user);
    void updateUser(User user);
    void deleteUserById(int id);
    User findById(int id);
    List<User> findByName(String username);
    int findTotal();

    List<User> findByQueryVo(QueryVo vo);
}
