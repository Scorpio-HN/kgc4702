package com.cssl.service;

import com.cssl.bean.Users;
import com.cssl.config.FeignHeaderConfiguration;
import com.cssl.service.impl.UsersFeginServiceImpl;
import org.apache.catalina.Session;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Component
@FeignClient(
        name="PROVIDER9091",
        fallback = UsersFeginServiceImpl.class,
        configuration= FeignHeaderConfiguration.class)
public interface UsersFenginService {
    //这些接口注意：要和提供者controller保持一致

    @RequestMapping("/login")
    public Users login(@RequestParam  String uname, @RequestParam String upwd);

    @RequestMapping("/showAll")
    public List<Users> showAll();

    @RequestMapping("/addUsers")
    public int addUsers(@RequestBody Users users);


    @RequestMapping("/testSession")
    public String testSession();
}
