package com.example.gen.service.impl;

import com.example.gen.entity.Student;
import com.example.gen.mapper.StudentMapper;
import com.example.gen.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author slz
 * @since 2019-11-02
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
