package com.cssl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.pojo.Student;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author slz
 * @since 2019-07-31
 */
public interface IStudentService extends IService<Student> {

    IPage<Student> fenYe(Page page);
    //public IPage<Map<String,Object>> findAll();
}
