package com.fslq.impl;

import com.fslq.dao.AccountDao;
import com.fslq.domain.Account;
import com.fslq.utils.JdbcDaoSupport;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/*
* 持久层实现类
* */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {


    @Override
    public Account findAccountById(Integer id) {
        List<Account> accounts=super.getJdbcTemplate().query( "select * from account where id=?",new BeanPropertyRowMapper<>(Account.class),id );
        return accounts.isEmpty()?null:accounts.get( 0 );
    }

    @Override
    public Account findAccountByName(String name) {
        List<Account> accounts=super.getJdbcTemplate().query( "select * from account where name =?",new BeanPropertyRowMapper<>(Account.class),name );
        if(accounts.isEmpty())
            return  null;
        if(accounts.size()>1)
            throw new RuntimeException( "结果集不唯一" );
        return accounts.get( 0 );
    }

    @Override
    public void updateAccount(Account account) {
        super.getJdbcTemplate().update( "update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId() );
    }
}
