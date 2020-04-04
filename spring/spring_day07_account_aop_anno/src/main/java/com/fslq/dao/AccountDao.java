package com.fslq.dao;

import com.fslq.domain.Account;

import java.util.List;

/*
* 持久层接口*/
public interface AccountDao {
    //    查询所有
    List<Account> findAllAccount();
    //    查询一个
    Account findByIdAccount(Integer id);
    //    保存账户
    void saveAccount(Account account);
    //    更新账户
    void updateAccount(Account account);
    //    删除账户
    void deleteByIdAccount(Integer id);
    //根据名称查询账户
    Account findByName(String name);
}
