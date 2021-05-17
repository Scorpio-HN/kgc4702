package com.cssl.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.pojo.Student;
import com.cssl.dao.StudentMapper;
import com.cssl.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author slz
 * @since 2019-07-31
 */
@Service
@Transactional
//@AutoConfigureAfter({StudentMapper.class})
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public IPage<Student> fenYe(Page page) {
        IPage<Student> studentIPage = studentMapper.selectPageVo(page);
        return studentIPage;
    }
}
