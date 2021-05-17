package com.cssl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	public HelloController() {
		System.out.println("xxx   HelloController");
		
	}

	@RequestMapping("/hello")
	public String hello() {
		//System.out.println("hello controller....");
		
		return "forward:/success.jsp";
	}
	
	@RequestMapping("/hello2")
	public String hello2() {
		System.out.println("xxxxx hello2");
		
		return "success";
	}
}
