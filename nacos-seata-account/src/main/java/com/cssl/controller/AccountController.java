package com.cssl.controller;

import com.cssl.pojo.Account;
import com.cssl.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountService service;

    @GetMapping("/account/update")
    public int update(int money,int user_id) throws Exception{
        //Thread.sleep(1500);
        return service.updateAccount(money,user_id);
    }

}
