package com.fslq.impl;

import com.fslq.service.AccountService;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    public void saveAccount() {
        System.out.println( "保存！" );
    }

    public void updateAccount(int i) {
        System.out.println( "更新" +10/0);
    }

    public int deleteAccount() {
        System.out.println( "删除！" );
        return 0;
    }
}
