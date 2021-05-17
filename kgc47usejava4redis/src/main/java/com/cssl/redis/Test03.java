package com.cssl.redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Test03 {
    private static JedisCluster jedis;
    static {
        // 添加集群的服务节点Set集合
        Set<HostAndPort> hostAndPortsSet = new HashSet<HostAndPort>();
        // 添加节点
        hostAndPortsSet.add(new HostAndPort("192.168.88.146", 7000));
        hostAndPortsSet.add(new HostAndPort("192.168.88.146", 7001));
        hostAndPortsSet.add(new HostAndPort("192.168.88.146", 7002));
        hostAndPortsSet.add(new HostAndPort("192.168.88.146", 7003));
        hostAndPortsSet.add(new HostAndPort("192.168.88.146", 7004));
        hostAndPortsSet.add(new HostAndPort("192.168.88.146", 7005));

        // Jedis连接池配置
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 最大空闲连接数, 默认8个
        jedisPoolConfig.setMaxIdle(100);
        // 最大连接数, 默认8个
        jedisPoolConfig.setMaxTotal(20);
        //最小空闲连接数, 默认0
        jedisPoolConfig.setMinIdle(0);
        // 获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1
        jedisPoolConfig.setMaxWaitMillis(6000); // 设置2秒
        //对拿到的connection进行validateObject校验
        jedisPoolConfig.setTestOnBorrow(true);
        //jedis.auth()
        jedis = new JedisCluster(hostAndPortsSet,60000,60000,60000,"123456", jedisPoolConfig);
    }

    public static void main(String[] args) throws InterruptedException {
        String id=jedis.get("id");
        System.out.println("id:"+id);
        System.out.println("jedis:"+jedis);


        //dolist();

        //=================
        // ==================
        //jedis.flushDB();
        //doString();
    }

    private static void doString() throws InterruptedException {
        System.out.println("===========增加数据===========");
        System.out.println(jedis.set("key1","value1"));
        System.out.println(jedis.set("key2","value2"));
        System.out.println(jedis.set("key3", "value3"));
        System.out.println("删除键key2:"+jedis.del("key2"));
        System.out.println("获取键key2:"+jedis.get("key2"));
        System.out.println("修改key1:"+jedis.set("key1", "value1Changed"));
        System.out.println("获取key1的值："+jedis.get("key1"));
        System.out.println("在key3后面加入值："+jedis.append("key3", "End"));
        System.out.println("key3的值："+jedis.get("key3"));
        //命令的时候才会去连接连接，集群中连接是对一个节点连接，不能判断多个key经过crc16算法所对应的槽在一个节点上，不支持多key获取、删除
        //System.out.println("增加多个键值对："+jedis.mset("key01","value01","key02","value02"));
        //System.out.println("获取多个键值对："+jedis.mget("key01","key02","key03"));
        //System.out.println("获取多个键值对："+jedis.mget("key01","key02","key03","key04"));
        //System.out.println("删除多个键值对："+jedis.del(new String[]{"key01","key02"}));
        //System.out.println("获取多个键值对："+jedis.mget("key01","key02","key03"));

        //jedis.flushDB();
        System.out.println("===========新增键值对防止覆盖原先值==============");
        System.out.println(jedis.setnx("key1", "value1"));
        System.out.println(jedis.setnx("key2", "value2"));
        System.out.println(jedis.setnx("key2", "value2-new"));
        System.out.println(jedis.get("key1"));
        System.out.println(jedis.get("key2"));

        System.out.println("===========新增键值对并设置有效时间=============");
        System.out.println(jedis.setex("key3", 2, "value3"));
        System.out.println(jedis.get("key3"));
        TimeUnit.SECONDS.sleep(3);
        System.out.println(jedis.get("key3"));

        System.out.println("===========获取原值，更新为新值==========");//GETSET is an atomic set this value and return the old value command.
        System.out.println(jedis.getSet("key2", "key2GetSet"));
        System.out.println(jedis.get("key2"));
        System.out.println("获得key2的值的字串："+jedis.getrange("key2", 2, 4)); // 相当截取字符串的第二个位置-第四个位置的字符串
    }

    private static void dolist() throws InterruptedException {
        //System.out.println("清空数据："+jedis.flushDB());
        System.out.println("判断某个键是否存在："+jedis.exists("username"));
        System.out.println("新增<'username','wukong'>的键值对："+jedis.set("username", "xiaohai"));
        System.out.println("是否存在:"+jedis.exists("username"));
        System.out.println("新增<'password','password'>的键值对："+jedis.set("password", "123456"));
        //Set<String> keys = jedis.keys("*");
        // System.out.println("系统中所有的键如下："+keys);
        System.out.println("删除键password:"+jedis.del("password"));
        System.out.println("判断键password是否存在："+jedis.exists("password"));
        System.out.println("设置键username的过期时间为10s:"+jedis.expire("username", 10));
        TimeUnit.SECONDS.sleep(2); // 线程睡眠2秒System.out.println("查看键username的剩余生存时间："+jedis.ttl("username"));
        System.out.println("查看键username的剩余生存时间："+jedis.ttl("username"));
        System.out.println("移除键username的生存时间："+jedis.persist("username"));
        System.out.println("查看键username的剩余生存时间："+jedis.ttl("username"));
        System.out.println("查看键username所存储的值的类型："+jedis.type("username"));
    }


}
