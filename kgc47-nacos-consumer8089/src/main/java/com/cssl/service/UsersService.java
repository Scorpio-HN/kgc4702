package com.cssl.service;

import com.cssl.bean.Users;
import com.cssl.service.impl.UserServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient(value = "nacos-provider",fallback = UserServiceImpl.class)
public interface UsersService {

    @RequestMapping("/login")
    public String login(@RequestParam String name, @RequestParam String pass);


    @RequestMapping("/hello")

    public Users hello(@RequestBody Users user);

}
