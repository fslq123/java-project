package com.fslq.service;

import com.fslq.domain.Account;

public interface AccountService {
    void findAccountByIdPrint(Integer id);
    void findAccountByNamePrint(String name);
    void updateAccountOperate(Account account);
    //转账
    void transfer(String sname,String tname,Float money);
}
