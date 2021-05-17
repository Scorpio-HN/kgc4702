package com.cssl.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyAdvice {
	
	@ExceptionHandler(Exception.class)
	public String doError(Exception e) {
		System.out.println("e:"+e.getMessage());
		return "forward:/error.jsp";
	}

}
