package com.cssl.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Test02 {

    public static void main(String[] args) {
        //创建连接池对象
        JedisPool jedispool = new JedisPool("192.168.88.146",6379);
        //从连接池中获取一个连接
        Jedis jedis = jedispool.getResource();
        jedis.auth("123456");
        //使用jedis操作redis
        jedis.set("userName", "张飞真好看"); //从服务器
        String str = jedis.get("userName");
        System.out.println(str);
        //使用完毕 ，关闭连接，连接池回收资源
        jedis.close();
        //关闭连接池
        jedispool.close();
    }
}
