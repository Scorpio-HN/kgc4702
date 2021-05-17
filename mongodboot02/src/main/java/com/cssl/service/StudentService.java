package com.cssl.service;

import com.cssl.entity.Student;
import com.mongodb.MongoTimeoutException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ExecutableFindOperation;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private MongoTemplate mongoTemplate;


    public String saveStudent(Student student){
        System.out.println("stu:"+student);
        Student save = mongoTemplate.save(student);
        System.out.println("输出结果："+save);

        return "添加成功";

    }

    //查询全部
    public List<Student> findAll(){
     return   mongoTemplate.findAll(Student.class);
    }



    public Student findAllById(Integer id){
        Query query=new Query(Criteria.where("sid").is(id));
        Student byId = mongoTemplate.findOne(query,Student.class);

        return byId;

    }
}
