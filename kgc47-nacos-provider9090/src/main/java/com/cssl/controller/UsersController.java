package com.cssl.controller;

import com.cssl.bean.Users;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @RequestMapping("/login")

    public String login(String name,String pass){
        System.out.println("9090提供者："+name+":"+pass);
   //int i=10/0;
        return "欢迎"+name;
    }

    @RequestMapping("/hello")

    public Users hello(@RequestBody Users user) throws InterruptedException {
        System.out.println("9090提供者："+user.getUname()+":"+user.getUpwd());
        user.setUname("我是烧饼");
        user.setUpwd("123456");
        //Thread.sleep(900);
        return user;
    }

}
