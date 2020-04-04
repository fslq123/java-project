package com.fslq.dao;

import com.fslq.domain.Account;
import com.fslq.domain.AccountUser;
import com.fslq.domain.User;

import java.util.List;

public interface AccountDao {
    List<Account> findAll();
    List<Account> findById(int i);//
    List<AccountUser> findAccountUserAll();
    List<Account> findAccountUserMap();
}
