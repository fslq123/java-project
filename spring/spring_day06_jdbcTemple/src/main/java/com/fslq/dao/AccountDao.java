package com.fslq.dao;

import com.fslq.domain.Account;

/*持久层接口*/
public interface AccountDao {
    Account findAccountById(Integer id);
    Account findAccountByName(String name);
    void updateAccount(Account account);
}
