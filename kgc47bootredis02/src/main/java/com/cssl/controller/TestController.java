package com.cssl.controller;

import com.cssl.pojo.Student;

import com.cssl.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class TestController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;


    @Autowired
    RedisUtil redisUtil;


    @ResponseBody
    @RequestMapping("/test1")
    public String test1(){
        System.out.println("test1..............");
            stringRedisTemplate.opsForValue().set("hh","测试字符串内容");
            redisUtil.set("sb2","xxx",5L);

        System.out.println("sb2:"+redisUtil.get("sb2"));

        return stringRedisTemplate.opsForValue().get("hh");
    }

    @ResponseBody
    @RequestMapping("/test2")
    public String test2(){
        System.out.println("test2..............");
        Student stu=new Student();
        stu.setSid(108);
        stu.setSname("张飞");
        stu.setBorndate(new Date());
        redisTemplate.opsForValue().set("stu",stu);
        //stringRedisTemplate.opsForValue().set("hh","测试字符串内容");

        return "success";
    }

    @ResponseBody
    @RequestMapping("/test3")
    public Student test3(){

        Student stu = (Student)redisTemplate.opsForValue().get("stu");


        return stu;
    }
}
