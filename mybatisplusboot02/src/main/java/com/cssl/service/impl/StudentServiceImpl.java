package com.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.StudentDao;
import com.cssl.pojo.Student;
import com.cssl.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly = false,rollbackFor=Exception.class)
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements StudentService {


    @Override
    public boolean dd(int id) {
        int i=1/0;

        return this.removeById(id);
    }
}
