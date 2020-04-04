package com.fslq.dao;

import com.fslq.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    User findById(int id);
    List<User> findUserAccountMap();
}
