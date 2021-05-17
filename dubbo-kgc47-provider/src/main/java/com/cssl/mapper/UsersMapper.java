package com.cssl.mapper;

import com.cssl.pojo.Users;

import java.util.List;

public interface UsersMapper {

    public Users login(String uname, String upwd);

    public List<Users> showAll();
}
