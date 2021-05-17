package com.cssl.redis;

import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//简单使用redis连接方式
public class Test01 {

    public static void main(String[] args) {
        Jedis jedis=new Jedis("192.168.88.146",6379);
        jedis.auth("123456");
        jedis.set("xx","admin");

        //jedis.set("userName", "李四");
        //System.out.println("输出："+jedis.get("kk"));
        doObject( jedis);
    }
    //测试存对象
    public static void  doObject(Jedis jedis){
        Student stu=new Student(102,"张三",new Date());
        Map<String,String> map=new HashMap<String,String>();
        map.put("sid",stu.getSid().toString());
        map.put("sname",stu.getSname());
        map.put("borndate",stu.getBonrdate().toString());
        String stu1 = jedis.hmset("stu2", map);
        //jedis.hmse
        //jedis.hmset()
        //System.out.println("stusss:"+stu1);
        List<String> hmget = jedis.hmget("stu2", "sname", "borndate");
        for (String s:hmget){
            System.out.println("ss:"+s);
        }
    }
}
