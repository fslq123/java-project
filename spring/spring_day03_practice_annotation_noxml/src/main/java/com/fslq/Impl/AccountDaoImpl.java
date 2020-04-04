package com.fslq.Impl;

import com.fslq.dao.AccountDao;
import com.fslq.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    //数据库查询调用类
    @Autowired
    private QueryRunner queryRunner;

    public QueryRunner getQueryRunner() {
        return queryRunner;
    }

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner=queryRunner;
    }

    public List<Account> findAllAccount() {
        try {
            return queryRunner.query("select * from account;",new BeanListHandler<>(Account.class));//返回列表
        }catch(SQLException e){
            System.out.println("查询所有失败");
            throw new RuntimeException(e);
        }
    }

    public Account findByIdAccount(Integer id) {
        try {
            return queryRunner.query("select * from account where id=?",id,new BeanHandler<Account>(Account.class));//返回一条信息
        }catch(SQLException e){
            System.out.println("通过id查询失败");
            throw new RuntimeException(e);
        }
    }

    public void saveAccount(Account account) {
        try {
            queryRunner.update("insert into account(name,money) value(?,?);",account.getName(),account.getMoney());
        }catch(SQLException e){
            System.out.println("保存失败");
            throw new RuntimeException(e);
        }
    }

    public void updateAccount(Account account) {
        try {
            queryRunner.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        }catch(SQLException e){
            System.out.println("更新失败");
            throw new RuntimeException(e);
        }
    }

    public void deleteByIdAccount(Integer id) {
        try {
            queryRunner.execute("delete from account where id=?",id);
        }catch(SQLException e){
            System.out.println("删除失败");
            throw new RuntimeException(e);
        }
    }
}
