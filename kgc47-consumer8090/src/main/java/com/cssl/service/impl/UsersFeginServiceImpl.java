package com.cssl.service.impl;

import com.cssl.bean.Users;
import com.cssl.service.UsersFenginService;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UsersFeginServiceImpl implements UsersFenginService {

    @Override
    public Users login(String uname, String upwd) {
        System.out.println("登录失败---降级处理....");
        //ResultComment {code : mess:}
        return new Users();
    }

    @Override
    public List<Users> showAll() {
        System.out.println("showAll---降级处理....");
        return null;
    }

    @Override
    public int addUsers(Users users) {
        System.out.println("addUsers---降级处理....");
        return 0;
    }

    @Override
    public String testSession() {
        System.out.println("session降级....");
        return null;
    }
}
