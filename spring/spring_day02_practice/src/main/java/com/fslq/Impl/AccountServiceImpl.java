package com.fslq.Impl;

import com.fslq.dao.AccountDao;
import com.fslq.domain.Account;
import com.fslq.service.AccountService;

import java.util.List;

/*
* 账户的业务层实现类*/
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao=accountDao;
    }

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }
    public Account findByIdAccount(Integer id) {
        return accountDao.findByIdAccount(id);
    }
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }
    public void deleteByIdAccount(Integer id) {
        accountDao.deleteByIdAccount(id);
    }
}
