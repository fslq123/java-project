package com.fslq.Impl;

import com.fslq.dao.AccountDao;
import com.fslq.domain.Account;
import com.fslq.utils.ConnectUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    //数据库查询调用类
    private QueryRunner queryRunner;
    //实例化数据库连接对象
    private ConnectUtils connectionUtils;



    public void setConnectionUtils(ConnectUtils connectionUtils) {
        this.connectionUtils=connectionUtils;
    }

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner=queryRunner;
    }

    public List<Account> findAllAccount() {
        try {
            return queryRunner.query(connectionUtils.getTheadConnection(),"select * from account;",new BeanListHandler<>(Account.class));//返回列表
        }catch(SQLException e){
            System.out.println("查询所有失败");
            throw new RuntimeException(e);
        }
    }

    public Account findByIdAccount(Integer id) {
        try {
            System.out.println("这里");
            return queryRunner.query(connectionUtils.getTheadConnection(),"select * from account where id=?",id,new BeanHandler<Account>(Account.class));//返回一条信息
        }catch(SQLException e){
            System.out.println("通过id查询失败"+e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void saveAccount(Account account) {
        try {
            queryRunner.update(connectionUtils.getTheadConnection(),"insert into account(name,money) value(?,?);",account.getName(),account.getMoney());
        }catch(SQLException e){
            System.out.println("保存失败");
            throw new RuntimeException(e);
        }
    }

    public void updateAccount(Account account) {
        try {
            queryRunner.update(connectionUtils.getTheadConnection(),"update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        }catch(SQLException e){
            System.out.println("更新失败");
            throw new RuntimeException(e);
        }
    }

    public void deleteByIdAccount(Integer id) {
        try {
            queryRunner.execute(connectionUtils.getTheadConnection(),"delete from account where id=?",id);
        }catch(SQLException e){
            System.out.println("删除失败");
            throw new RuntimeException(e);
        }
    }
    @Override
    public Account findByName(String name) {
        try {
            List<Account> accounts=queryRunner.query(connectionUtils.getTheadConnection(),"select * from account where name=?",name,new BeanListHandler<>(Account.class));//返回信息
            if(accounts==null||accounts.size()==0)
                return null;
            if(accounts.size()>1)
                throw new RuntimeException("结果集不唯一");
            return accounts.get(0);
        }catch(SQLException e){
            System.out.println("通过name查询失败");
            throw new RuntimeException(e);
        }
    }


}
