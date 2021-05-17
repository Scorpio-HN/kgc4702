package com.cssl.service.impl;

import com.cssl.dao.AccountDao;
import com.cssl.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public int updateAccount(int money, int user_id) {
        //int i=1/0;
        return accountDao.updateAccount(money,user_id);
    }
}
