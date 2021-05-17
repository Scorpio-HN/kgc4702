package com.cssl.controller;

import com.cssl.bean.Users;
import com.cssl.service.UsersFenginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UsersController {

   //依赖业务逻辑层 UsersFenginService

    @Autowired
    private UsersFenginService usersFenginService;

    @ResponseBody
    @GetMapping("/findAll")
    public List<Users> findAll(){

        List<Users> users = usersFenginService.showAll();
        //users.forEach(u-> System.err.println(u));

        return users;

    }

    @ResponseBody
    @PostMapping("/login")
    public Users login(String uname,String upwd){
        System.out.println("传入参数："+uname+":::"+upwd);
        Users login = usersFenginService.login(uname, upwd);
        System.out.println("登录成功----》》》》》"+login);
        return login;

    }


    @ResponseBody
    @PostMapping("/add")
    public int add(Users user){
        System.out.println("传入参数："+user);
        int login = usersFenginService.addUsers(user);
        System.out.println("登录成功----》》》》》"+login);
        return login;

    }

    @ResponseBody
    @RequestMapping("/test")
    public String testMap(@RequestHeader("token") String token){
        System.out.println("xxxxxxxxxxxxxxxxxxxxx:"+token);

        return "烧饼好吃";
    }

    @ResponseBody
    @RequestMapping("/testSession")
    public String testSession(HttpSession session,String uname,String pass){

        System.out.println("消费者8090====》sessionId:"+session.getId());
        session.setAttribute("user",uname);

        String s = usersFenginService.testSession();
        System.out.println("提供者返回："+s);

        return "消费者sesssionId:"+session.getId()+"====提供者:"+s;
    }


    //解决第一次访问的sessionId不同的方法
    @RequestMapping("/testSession2")
    @ResponseBody
    public String testSession2(HttpSession session,String uname,String pass){
        System.out.println("周转方法....................");
       return  testSession(session,uname,pass);

    }

}
