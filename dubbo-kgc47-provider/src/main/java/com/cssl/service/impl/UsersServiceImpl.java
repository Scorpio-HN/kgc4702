package com.cssl.service.impl;

import com.cssl.mapper.UsersMapper;
import com.cssl.pojo.Users;
import com.cssl.service.UsersService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Service
public class UsersServiceImpl implements UsersService {


    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Users login(String uname, String upwd) {
        System.out.println("我是提供者9080---登录方法："+uname+"::::"+upwd);
        return usersMapper.login(uname,upwd);
    }

    @Override
    public List<Users> showAll()
    {
        System.out.println("我是提供者9080--查询全部方法");
        return usersMapper.showAll();
    }
}
