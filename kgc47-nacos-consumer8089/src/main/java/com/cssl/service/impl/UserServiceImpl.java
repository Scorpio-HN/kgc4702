package com.cssl.service.impl;

import com.cssl.bean.Users;
import com.cssl.service.UsersService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UsersService {


    @Override
    public String login(String name, String pass) {
        System.out.println("熔断降级..........："+name+":pass:"+pass);
        return "服务器正忙，请稍后重试.....";
    }

    @Override
    public Users hello(Users user) {
        return null;
    }
}
