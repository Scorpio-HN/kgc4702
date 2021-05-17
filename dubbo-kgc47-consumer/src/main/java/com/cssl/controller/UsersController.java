package com.cssl.controller;

import com.cssl.pojo.Users;
import com.cssl.service.UsersService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    //@Autowired
    @Reference
    private UsersService usersService;

    @RequestMapping("/login")
    public Users login(String uname, String upwd){
        System.out.println("消费者--8090--login");
        return usersService.login(uname,upwd);
    }
    @RequestMapping("/showAll")
    public List<Users> showAll(){
        System.out.println("消费者--8090--showAll");
        return usersService.showAll();
    }

}
