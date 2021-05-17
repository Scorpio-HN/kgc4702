package com.cssl.controller;

import com.cssl.pojo.Student;
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
    StringRedisTemplate stringRedisTemplate; //处理字符串

    @Autowired
    RedisTemplate redisTemplate;//处理对象

    @ResponseBody
    @RequestMapping("/test")
    public String test1(){
        System.out.println("测试");

        //保存字符串
        stringRedisTemplate.opsForValue().set("sb","保存点数据，放在redis玩下");
        
        //取出数据看看
        String sb = stringRedisTemplate.opsForValue().get("sb");
        return sb;
    }

    @RequestMapping("/test2")
    @ResponseBody
    public Student test2(){
        System.out.println("test2  .......");
        Student stu=new Student();
        stu.setSid(101);
        stu.setSname("张三");
        stu.setBirthDay(new Date());

        redisTemplate.opsForValue().set("stu2",stu);

        return (Student) redisTemplate.opsForValue().get("stu");

    }

    public String test3(){
        redisTemplate.opsForList().set("key",5000,"集合");

        return "success";
    }
}
