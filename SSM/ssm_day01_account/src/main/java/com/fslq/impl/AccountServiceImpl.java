package com.fslq.impl;

import com.fslq.dao.AccountDao;
import com.fslq.domain.Account;
import com.fslq.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/*
* 业务层实现类
* */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public List<Account> findAllAccount() {
        System.out.println( "Service执行" );
        List<Account> accounts=accountDao.findAll();
        accounts.stream().forEach( p->{
            System.out.println( "账号："+p.getId()+"  姓名："+p.getName()+"  金额："+p.getMoney() );
        } );
            return accounts;
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.save( account );
    }
}
