package com.cssl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@EnableTransactionManagement
@MapperScan("com.cssl.dao")
public class App {

    public static void main(String[] args) {
        System.out.println("hello world");
        SpringApplication.run(App.class,args);
    }
}
