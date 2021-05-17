package com.cssl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cssl.pojo.Student;

public interface StudentMapper {
	//查询全部学生
	public List<Student> showAll();
	
	//测试事务
	public int updateStudent(Student stu);
	
	
}
