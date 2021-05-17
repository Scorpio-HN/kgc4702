package com.cssl.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cssl.bean.Users;
import com.cssl.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UsersController {


    @Autowired
    private UsersService usersService;


    @RequestMapping("login")
    @ResponseBody
    @SentinelResource(value="/login",blockHandler = "callBack")
    public String testLogin(String name, String pass, HttpServletRequest request){
        System.out.println("消费者8090--"+name);
        String header = request.getHeader("X-Request-color");
        String color = request.getParameter("color");
        System.out.println("请求参数："+color);

        System.out.println("红色："+header);
        return usersService.login(name,pass);
        //int i=1/0;
        //return test2(name,pass);

    }



    @RequestMapping("/test2")
    @ResponseBody
    public String test2(String name,String pass){

        System.out.println("test2:"+name+":"+pass);

        return "烧饼"+name;
    }



    @RequestMapping("/myhello")
    @ResponseBody
    public Users myLogin(Users user){
        System.out.println("消费者8090--"+user);
        return usersService.hello(user);

    }


}
