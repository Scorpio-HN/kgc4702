package com.cssl.service;

import com.cssl.bean.Users;
import com.cssl.dao.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tym on 2018/8/27 0027.
 */
@Service
public class UsersServiceImpl implements UsersService {


    @Autowired
    private UsersRepository usersRepository;

    /**
     *  =========MongoDB=======
     */
    @Override
    public void save(Users user) {
        usersRepository.save(user);
    }

    @Override
    public Users findByName(String name) {
        return usersRepository.findByName(name);
    }

    /**
     *  =========Redis=======
     */
    @Override
    //@CachePut(value="user", key="#id", condition="#id%2==1", unless="#result==null")
    @Cacheable(value="user", key="#id", condition="#id%2==0", unless="#result==null")
    public Users getUser(int id) {
        System.out.println("UsersService getUser:"+id);
        Users user = new Users();
        user.setId(id);
        user.setName("灵哥");
        return user;
    }

    @Override
    @CacheEvict(value="user", key="#id", condition="#id%2==0")
    public Users delUser(int id) {
        System.out.println("UsersService del:"+id);
        Users user = new Users();
        user.setId(id);
        return user;
    }


}