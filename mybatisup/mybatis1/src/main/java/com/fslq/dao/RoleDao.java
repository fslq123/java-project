package com.fslq.dao;

import com.fslq.domain.Role;

import java.util.List;

public interface RoleDao {
    List<Role> findRoleAndUserMap();
}
