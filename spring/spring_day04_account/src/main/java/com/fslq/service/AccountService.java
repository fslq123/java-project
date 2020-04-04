package com.fslq.service;

import com.fslq.domain.Account;

import java.util.List;

/*
* 账户的业务层接口
* */
public interface AccountService {
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
//    转账
    boolean transfer(String sourceName,String targetName,Float money);
}
