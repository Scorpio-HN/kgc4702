package com.cssl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
@MapperScan("com.cssl.mapper")
@SpringBootApplication
@ServletComponentScan("com.cssl.web")
public class Kgc47boot01Application extends SpringBootServletInitializer {

//	public static void main(String[] args) {
//		SpringApplication.run(Kgc47boot01Application.class, args);
//	}


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Kgc47boot01Application.class);
	}
}
