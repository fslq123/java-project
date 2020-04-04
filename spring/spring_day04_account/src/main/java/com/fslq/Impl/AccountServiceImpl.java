package com.fslq.Impl;

import com.fslq.dao.AccountDao;
import com.fslq.domain.Account;
import com.fslq.service.AccountService;
import com.fslq.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
* 账户的业务层实现类*/
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
//    添加事务控制
    public TransactionManager transactionManager;
    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager=transactionManager;
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao=accountDao;
    }
    public List<Account> findAllAccount() {
        try{
            //1.开启事务
            transactionManager.begin();
            //2.执行操作
            List<Account> accounts=accountDao.findAllAccount();
            //3.提交事务
            transactionManager.commit();
            //4.返回结果
            return accounts;
        }catch(Exception e){
            //5.回滚操作
            transactionManager.rollback();
        }finally {
            //6.释放连接
            transactionManager.release();
        }
        return null;
    }
    public Account findByIdAccount(Integer id) {
        try{
            //1.开启事务
            transactionManager.begin();
            //2.执行操作
            Account account=accountDao.findByIdAccount( id );
            //3.提交事务
            transactionManager.commit();
            //4.返回结果
            return account;
        }catch(Exception e){
            //5.回滚操作
            transactionManager.rollback();
        }finally {
            //6.释放连接
            transactionManager.release();
        }
        return null;
    }
    public void saveAccount(Account account) {
        try{
            //1.开启事务
            transactionManager.begin();
            //2.执行操作
            accountDao.saveAccount( account );
            //3.提交事务
            transactionManager.commit();
        }catch(Exception e){
            //5.回滚操作
            transactionManager.rollback();
        }finally {
            //6.释放连接
            transactionManager.release();
        }

    }
    public void updateAccount(Account account) {
        try{
            //1.开启事务
            transactionManager.begin();
            //2.执行操作
             accountDao.updateAccount( account );
            //3.提交事务
            transactionManager.commit();
        }catch(Exception e){
            //5.回滚操作
            transactionManager.rollback();
        }finally {
            //6.释放连接
            transactionManager.release();
        }
    }
    public void deleteByIdAccount(Integer id) {
        try{
            //1.开启事务
            transactionManager.begin();
            //2.执行操作
            accountDao.deleteByIdAccount( id );
            //3.提交事务
            transactionManager.commit();
        }catch(Exception e){
            //5.回滚操作
            transactionManager.rollback();
        }finally {
            //6.释放连接
            transactionManager.release();
        }
    }

    @Override
    public boolean transfer(String sourceName,String targetName,Float money) {
        try{
            //1.开启事务
            transactionManager.begin();
            //2.执行操作
            List<Account> accounts=accountDao.findAllAccount();
            //3.提交事务
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
            //4.返回结果
            return true;
        }catch(Exception e){
            //5.回滚操作
            transactionManager.rollback();
        }finally {
            //6.释放连接
            transactionManager.release();
        }
        return false;
    }
}
