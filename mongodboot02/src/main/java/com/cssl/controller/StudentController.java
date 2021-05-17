package com.cssl.controller;

import com.cssl.entity.Student;
import com.cssl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class StudentController {


    @Autowired
    private StudentService studentService;


    @RequestMapping("/add")
    public String addStudent(@RequestBody Student student){

     return     studentService.saveStudent(student);

    }



    @RequestMapping("/findAll")
    public List<Student> findAll(){

        return     studentService.findAll();

    }

    @RequestMapping("/findById")
    public Student findById( Integer id){

        return    studentService.findAllById(id);

    }




}
