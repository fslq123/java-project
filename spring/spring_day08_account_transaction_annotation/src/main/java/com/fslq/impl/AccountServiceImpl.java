package com.fslq.impl;

import com.fslq.dao.AccountDao;
import com.fslq.domain.Account;
import com.fslq.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)//只读型事务配置
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
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

    @Transactional(propagation=Propagation.REQUIRED,readOnly=false)//读写型事务配置
    @Override
    public void transfer(String sname,String tname,Float money) {
        Account source=accountDao.findAccountByName(sname);
        Account target=accountDao.findAccountByName(tname);
        float smoney=source.getMoney();
        float tmoney=target.getMoney();
        if(smoney>=money)
        {
            source.setMoney(smoney-money);
            target.setMoney(tmoney+money);
            accountDao.updateAccount(source);
            int i=10/0;
            accountDao.updateAccount(target);
        }
    }
}
