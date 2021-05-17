package com.cssl;

import com.cssl.mapper.UserMapper;
import com.cssl.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class Kgc47mybatisplusApplicationTests {
    @Autowired
    private UserMapper userMapper;

    //@Autowired
   // private UserService userService;
    @Test
    void contextLoads() {

        //User user = userMapper.selectById(4);

        //System.out.println("对："+user);

        System.out.println("********************");
       // List<User> users = userMapper.selectList(null);
        //users.forEach(System.out::println);

        System.out.println("************************");

        User user2=new User();
        user2.setId(6L);
        user2.setAge(202);
        user2.setName("测试2");
        //user2.setId(4L);

       // int i = userMapper.updateById(user2);
        //System.out.println("row:"+i);

        int insert = userMapper.insert(user2);
        System.out.println("row:"+insert);

        System.out.println("user:"+user2);

        //userService.save()


    }

}
