package com.cssl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cssl.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

//持久层注解
@Repository
public interface UserMapper extends BaseMapper<User> {

    public List<User> show();
}
