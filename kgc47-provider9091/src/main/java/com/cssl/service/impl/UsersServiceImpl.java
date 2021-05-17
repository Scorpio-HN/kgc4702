package com.cssl.service.impl;

import com.cssl.bean.Users;
import com.cssl.mapper.UsersMapper;
import com.cssl.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Users login(String uname, String upwd) {
        return usersMapper.login(uname,upwd);
    }

    @Override
    public List<Users> showAll() {
        return usersMapper.showAll();
    }

    @Override
    public int addUsers(Users users) {
        return usersMapper.addUsers(users);
    }
}
