package com.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cssl.pojo.Student;
import com.cssl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;


    //查询全部信息
    @RequestMapping("/showAll")
    @ResponseBody
    public List<Student> showAll() {
        System.out.println("进入controller");
        List<Student> list = studentService.list();
        for (Student s : list) {
            System.out.println("学生：" + s);
        }
        return list;
    }

    //查询全部信息 页面渲染
    @RequestMapping("/showAll2")
    public String showAll2(Model model) {
        System.out.println("进入controller");
        List<Student> list = studentService.list();
        for (Student s : list) {
            System.out.println("学生2：" + s);
        }
        model.addAttribute("list",list);
        return "index";
    }


    //入参map
    @ResponseBody
    @RequestMapping("/showAllByMap")
    public List<Student> showAllByMap(){
        Map<String,Object> param = new HashMap<>();
        param.put("sid","2");
        param.put("stu_name","吴用");
        List<Student> students = studentService.listByMap(param);
        return students;
    }






    //新增学生
    @RequestMapping("/addStudent")
    @ResponseBody
    public String addStudent(){
        Student stu=new Student();
        stu.setBorndate(new Date());
        stu.setAge(100);
        stu.setEmail("123456@qq.com");
        stu.setStuName("潘金莲");
        boolean num = studentService.save(stu);
        //studentService.sa
        System.out.println("新增之后立马获取sid:"+stu.getSid());
        return num?"成功":"失败";
    }


    //修改学生
    @ResponseBody
    @RequestMapping("/updateStudent")
    public String updateStudent(){
        Student stu=new Student();
        stu.setSid(21);
        stu.setStuName("新增一个小潘嘻嘻嘻");
        stu.setEmail("66664@qq.com");
        stu.setAge(66);
        stu.setBorndate(java.sql.Date.valueOf("2008-05-08"));

        //boolean b = studentService.updateById(stu);
        boolean b = studentService.saveOrUpdate(stu);

       // studentService.update();

        return b?"修改成功":"修改失败";
    }


    @RequestMapping("/delete")
    public String deleteStudent(){
       // boolean b = studentService.removeById(14);

        //System.out.println("删除："+b);
        boolean dd = studentService.dd(21);
        System.out.println("ddd:"+dd);

        return "success";
    }

    //查询 系列方法
    @RequestMapping("/query")
    @ResponseBody
    public String queryAllmethod(){

        //1.根据id查询
        //Student byId = studentService.getById(4);
        //System.out.println("根据id查询返回的对象："+byId);

        //2.通过多个列查询 selectOne
        Student student = new Student();
        student.setSid(3);
        student.setStuName("公");

        //设置参数
        QueryWrapper<Student> sq = new QueryWrapper<>();
//        sq.eq("sid", student.getSid());
//
//        sq.like("stu_name",student.getStuName());
//        Student one = studentService.getOne(sq);
//        System.out.println("根据idgetOne查询返回的对象one："+one);



        //指定多条件查询
//        sq.ge("sid",4);
//        sq.like("email","6");
//       List<Student> list = studentService.list(sq);
//       for (int i = 0; i <list.size() ; i++) {
//           System.out.println("学生****："+list.get(i));
//       }

        System.out.println("************************查询返回map**************************");
        //查询返回map
       // Map<String, Object> map = studentService.getMap(sq.eq("sid",6));
       // System.out.println("学生map:"+map);

        System.out.println("************************批量查询**************************");
        //批量查询
        List<String> ids = Arrays.asList("1", "6", "45", "3");
        //studentService.up
        List<Student> students = studentService.listByIds(ids);
        for (Student s:students) {
            System.out.println("批量学生："+s);
        }


        return "success";
    }


    //分页查询
    @RequestMapping("/page")
    @ResponseBody
    public String showPage(){
        //Page<Student> page = studentService.page(new Page<Student>(2, 2));


        //带条件查询分页
        QueryWrapper<Student> sq = new QueryWrapper<>();
        sq.like("email","6").orderByDesc("sid");
        Page<Student> page = studentService.page(new Page<Student>(1, 4),sq);



        for(Student s:page.getRecords()){
            System.out.println("学生："+s);
        }
        System.out.println("集合："+page.getRecords());
        System.out.println("总记录数："+page.getTotal());
        System.out.println("总页数："+page.getPages());
        System.out.println("当前页："+page.getCurrent());
        System.out.println("每页容量："+page.getSize());

        return "success";
    }
}
