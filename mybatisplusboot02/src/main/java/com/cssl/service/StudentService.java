package com.cssl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.pojo.Student;

public interface StudentService extends IService<Student> {


    public boolean dd(int id);
}
