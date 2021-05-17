package com.cssl.mapper;

import com.cssl.bean.Users;

import java.util.List;

public interface UsersMapper {

    public Users login(String uname, String upwd);

    public List<Users> showAll();

    public int addUsers(Users users);
}
