package com.fslq.service;

import com.fslq.domain.Account;
import org.springframework.stereotype.Service;

import java.util.List;

/*业务层接口*/

public interface AccountService {
    //查询所有
    List<Account> findAllAccount();
    //添加一个
    void saveAccount(Account account);

}
