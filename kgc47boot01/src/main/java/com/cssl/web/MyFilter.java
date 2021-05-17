package com.cssl.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cssl.service.StudentService;
@WebFilter("/*")
public class MyFilter implements Filter {

	@Autowired
	private StudentService studentServiceImpl; 
	
    public MyFilter() {
       System.err.println("过滤器中studentServiceImpl："+studentServiceImpl);
    }

	
	public void destroy() {
		System.err.println("销毁方法........");
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.err.println("过滤前："+studentServiceImpl);
		chain.doFilter(request, response);
		System.err.println("过滤后："+studentServiceImpl);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.err.println("过滤器中init："+studentServiceImpl);

		ServletContext application = fConfig.getServletContext(); //springboot
		ApplicationContext act=WebApplicationContextUtils.getWebApplicationContext(application);
		
		//tomcat启动时，从spring中获取容器，从容器中取出我们要的bean Spring()
		//WebApplicationContext act=ContextLoader.getCurrentWebApplicationContext();
		 this.studentServiceImpl = act.getBean(StudentService.class);
		System.err.println("过滤器中的init---studentService:"+studentServiceImpl);
	}
	

}
