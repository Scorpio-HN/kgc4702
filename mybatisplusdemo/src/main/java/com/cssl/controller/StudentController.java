package com.cssl.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cssl.pojo.Student;
import com.cssl.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author slz
 * @since 2019-07-31
 */
@Controller
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;


    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("xxxx");

       // List<Student> list = studentService.list();


       /* List<Student> list = studentService.list(
				new QueryWrapper<Student>().lt("sid",25)
						.likeRight("sname","黄").orderByDesc("borndate"));
*/




       /* Map<String,Object> param = new HashMap<>();
        param.put("sid","20");
        param.put("sname","黄大仙");
        Collection<Student> list = studentService.listByMap(param);
*/

        //studentService.pa
        IPage page = studentService.page(new Page(1, 5));
        long pages = page.getPages();
        long total = page.getTotal();
        long current = page.getCurrent();
        List list = page.getRecords();
        long size = page.getSize();
        System.out.println("pages:"+pages);
        System.out.println("total:"+total);
        System.out.println("current:"+current);
        System.out.println("size:"+size);
        for(Object o:list){
            System.out.println("oo:"+o);
        }
        System.out.println("*******************");
        /*for (Student s:list) {
            System.out.println("s:"+s);
        }*/
        model.addAttribute("list",list);
        return "index";
    };


    @RequestMapping("/findByid")
    public String findStudent(Integer sid){
        Student byId = studentService.getById(sid);
        System.out.println("对象："+byId);


        return "index";
    }



    @RequestMapping("/add")
    public void addStudent(){
        Student student=new Student();
        student.setSname("pgone");
        student.setBorndate(null);
        boolean save = studentService.save(student);
        System.out.println("******************save:"+save);

    }



}
