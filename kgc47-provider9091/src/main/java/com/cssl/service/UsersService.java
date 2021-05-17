package com.cssl.service;

import com.cssl.bean.Users;

import java.util.List;

public interface UsersService {

    public Users login(String uname, String upwd);

    public List<Users> showAll();

    public int addUsers(Users users);
}
