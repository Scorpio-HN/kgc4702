package com.cssl.controller;

import com.cssl.bean.Users;
import com.cssl.service.UsersService;
import com.netflix.discovery.converters.Auto;
import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping("/login")
    public Users login(String uname, String upwd){
        System.out.println("提供者9091---login:::"+uname+"::::"+upwd);
      return  usersService.login(uname,upwd);
    }

    @RequestMapping("/showAll")
    public List<Users> showAll(){

       /* System.out.println("提供者9091---showAll:::");
        try {
            System.out.println("提供者休眠10秒");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/


        return usersService.showAll();
    }

    @RequestMapping("/addUsers")
    public int addUsers(@RequestBody Users users){
        System.out.println("提供者9091---addUsers:::"+users);
        return usersService.addUsers(users);
    }

    @RequestMapping("/testSession")
    public String testSession(HttpSession session){
        String id = session.getId();
        Object uname = session.getAttribute("user");

        System.out.println("提供者9091===>>>sessionId:"+id+":::uname:"+uname);
        return "sesssionId:"+id;
    }
}
