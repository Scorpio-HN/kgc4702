package com.cssl.controller;

import com.cssl.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model,HttpSession session){
        System.out.println("进入hello");
        //测试脚本和p段落显示
        model.addAttribute("mess","测试数据");

        //测试sessionu作用域取值
        System.out.println("进入session");
        session.setAttribute("student",new Student(103,"华莱士",new Date()));

        //测试样式控制百分比
        model.addAttribute("count",60.0);
        model.addAttribute("totalNum",100);

        
        
        //测试集合
        List<Student> list=new ArrayList<Student>();
        list.add(new Student(101,"陈金",new Date()));
        list.add(new Student(102,"陈翔",new Date()));
        list.add(new Student(103,"陈龙",new Date()));
        list.add(new Student(104,"陈坤",new Date()));
        list.add(new Student(105,"陈老李",new Date()));

        //<c:foreach item="${stuList}" var="stu" varstatu=sta
        //<tr th:each="stu,sta:${stuList}">
        model.addAttribute("stuList",list);

        //测试下来框
        List<String> citys=new ArrayList<String>();
        citys.add("北京");
        citys.add("上海");
        citys.add("广州");
        citys.add("深圳");
        citys.add("成都");

        
        model.addAttribute("citys",citys);

        
        //测试回显下拉框
        Student cx = new Student(103, "陈翔", new Date());
        model.addAttribute("obj",cx);


        //测试图片路径
        model.addAttribute("imagePath","http://127.0.0.1:8080/thy/images/g2.jpg");

        //测试数据格式
        model.addAttribute("num1",1332.56856);//0012.56
        model.addAttribute("num2",12.56);


        //测试连接
        model.addAttribute("url","<a href='http://www.baidu.com'>百度</a>");

        return "index";
    }




}
