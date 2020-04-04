package com.fslq.Impl;

import com.fslq.dao.AccountDao;
import com.fslq.domain.Account;
import com.fslq.service.AccountService;
import com.fslq.utils.TransactionManager;

import java.util.List;

/*
* 账户的业务层实现类*/
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao=accountDao;
    }
    public List<Account> findAllAccount() {
            return accountDao.findAllAccount();
    }
    public Account findByIdAccount(Integer id) {
       return accountDao.findByIdAccount( id );
    }
    public void saveAccount(Account account) {
            accountDao.saveAccount( account );
    }
    public void updateAccount(Account account) {
            accountDao.updateAccount( account );
    }
    public void deleteByIdAccount(Integer id) {
            accountDao.deleteByIdAccount( id );
    }

    @Override
    public void transfer(String sourceName,String targetName,Float money) {
            Account source=accountDao.findByName(sourceName);
            Account target=accountDao.findByName(targetName);
            float smoney=source.getMoney();
            float tmoney=target.getMoney();
            if(smoney>money)
            {
                source.setMoney(smoney-money);
                target.setMoney(tmoney+money);
                accountDao.updateAccount(source);
                accountDao.updateAccount(target);
            }
    }
}
