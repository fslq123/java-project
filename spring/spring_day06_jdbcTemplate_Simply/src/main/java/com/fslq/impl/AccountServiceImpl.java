package com.fslq.impl;

import com.fslq.dao.AccountDao;
import com.fslq.domain.Account;
import com.fslq.service.AccountService;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao=accountDao;
    }

    @Override
    public void findAccountByIdPrint(Integer id) {
        Account account=accountDao.findAccountById( id );
        System.out.println("姓名："+account.getName()+" 金额："+account.getMoney());
    }

    @Override
    public void findAccountByNamePrint(String name) {
        Account account=accountDao.findAccountByName( name );
        System.out.println("编号："+account.getId()+" 金额："+account.getMoney());
    }

    @Override
    public void updateAccountOperate(Account account) {
        accountDao.updateAccount( account );
    }
}
