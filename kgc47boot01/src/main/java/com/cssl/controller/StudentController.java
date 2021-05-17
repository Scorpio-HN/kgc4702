package com.cssl.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cssl.pojo.Student;
import com.cssl.service.StudentService;
import com.github.pagehelper.Page;

@RestController
public class StudentController {
	
	@Resource
	private StudentService studentService;
	
	@RequestMapping("/getAll")//@PathVariable int pageIndex {pageIndex}
	public List<Student> getAllStudent() {
		System.out.println("xxxxxxxxxxxxx");
		//int i=1/0;
		return studentService.showAllPage(1, 10);
	}
	
	
	public String updateStudent(Student stu) {
		
		boolean rs = studentService.updateStudent(stu);
		
		return rs?"success":"error";
	}
	

}
