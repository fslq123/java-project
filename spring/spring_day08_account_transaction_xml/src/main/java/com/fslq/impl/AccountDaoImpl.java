package com.fslq.impl;

import com.fslq.dao.AccountDao;
import com.fslq.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/*
* 持久层实现类
* */
public class AccountDaoImpl implements AccountDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate=jdbcTemplate;
    }

    @Override
    public Account findAccountById(Integer id) {
        List<Account> accounts=jdbcTemplate.query( "select * from account where id=?",new BeanPropertyRowMapper<>(Account.class),id );
        return accounts.isEmpty()?null:accounts.get( 0 );
    }

    @Override
    public Account findAccountByName(String name) {
        List<Account> accounts=jdbcTemplate.query( "select * from account where name =?",new BeanPropertyRowMapper<>(Account.class),name );
        if(accounts.isEmpty())
            return  null;
        if(accounts.size()>1)
            throw new RuntimeException( "结果集不唯一" );
        return accounts.get( 0 );
    }

    @Override
    public void updateAccount(Account account) {
        jdbcTemplate.update( "update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId() );
    }
}
