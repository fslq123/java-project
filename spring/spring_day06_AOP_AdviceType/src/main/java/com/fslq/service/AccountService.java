package com.fslq.service;
/*
* 业务层接口
* */
public interface AccountService {
    /*
    * 模拟保护账户
    * */
    void saveAccount();
    /*
    * 模拟更新账户
    * */
    void updateAccount(int i);
    /*
    * 删除账户
    * */
    int deleteAccount();
}
