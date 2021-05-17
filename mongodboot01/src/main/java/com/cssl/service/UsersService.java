package com.cssl.service;

import com.cssl.bean.Users;


import java.util.List;

/**
 * Created by tym on 2018/8/31 0031.
 */
public interface UsersService {
    void save(Users user);

    Users findByName(String name);

    Users getUser(int id);

    Users delUser(int id);


}
