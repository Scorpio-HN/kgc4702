package com.cssl.service;

import java.util.List;

import com.cssl.pojo.Student;
import com.github.pagehelper.Page;

public interface StudentService {

	
	public List<Student> showAll();
	
	public boolean updateStudent(Student stu);
	
	
	public Page showAllPage(int pageIndex, int pageSize);
}
