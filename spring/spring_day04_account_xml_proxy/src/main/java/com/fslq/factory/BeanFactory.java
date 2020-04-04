package com.fslq.factory;

import com.fslq.service.AccountService;
import com.fslq.utils.TransactionManager;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
* 创建Service的代理对象工厂
* */
public class BeanFactory {
    private AccountService accountService;
    //    添加事务控制
    public TransactionManager transactionManager;
    public  void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager=transactionManager;
    }
    public final void setAccountService(AccountService accountService) {
        this.accountService=accountService;
    }
    public AccountService getAccountService() {
       return (AccountService)Proxy.newProxyInstance( accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler(){
                    /**
                     * 添加事务的支持
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy,Method method,Object[] args) throws Throwable {
                        Object rtValue=null;
                        try{
                            //1.开启事务
                            transactionManager.begin();
                            //2.执行操作
                            rtValue=method.invoke( accountService ,args);
                            //3.提交事务
                            transactionManager.commit();
                            //4.返回结果
                            return rtValue;
                        }catch(Exception e){
                            //5.回滚操作
                            transactionManager.rollback();
                        }finally {
                            //6.释放连接
                            transactionManager.release();
                        }
                        return null;
                    }
                } );
    }

}
