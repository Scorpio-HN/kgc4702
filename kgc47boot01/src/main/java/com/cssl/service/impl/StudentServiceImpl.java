package com.cssl.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cssl.mapper.StudentMapper;
import com.cssl.pojo.Student;
import com.cssl.service.StudentService;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper sm;

	@Override
//	@Transactional(isolation =Isolation.DEFAULT,
//	propagation = Propagation.REQUIRED,timeout = -1 )
	public boolean updateStudent(Student stu) {
		int updateStudent = 0;

		System.out.println("xxxxxxx");
		updateStudent = sm.updateStudent(stu);
		//int i = 1 / 0;
		//下订单--》减库存
		return updateStudent > 0 ? true : false;
	}

	//@Transactional(readOnly = true)
	@Override
	public List<Student> showAll() {
		// TODO Auto-generated method stub
		return sm.showAll();
	}

	@Override
	public Page showAllPage(int pageIndex, int pageSize) {

		Page<Object> startPage = PageHelper.startPage(pageIndex, pageSize, "sid desc");
		List<Student> showAll = sm.showAll();
		System.out.println("showAllshowAllshowAllshowAllshowAll");
//		for (Student student : showAll) {
//			System.out.println("学生："+student);
//		}
		System.out.println("**********************");
		System.out.println("总页数：" + startPage.getPages());
		System.out.println("总记录数：" + startPage.getTotal());

		System.out.println("每页容量size:" + startPage.getPageSize());
		System.out.println("当前页码index:" + startPage.getPageNum());
		System.out.println("**********************");
		System.out.println("list:" + startPage.getResult());
		for (Object o : startPage.getResult()) {
			System.out.println("sss:" + o);
		}

		return startPage;
	}
}
