package com.cssl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@ServletComponentScan(basePackages = "com.cssl.filter")
public class Kgc47configserver3030Application {

    public static void main(String[] args) {
        SpringApplication.run(Kgc47configserver3030Application.class, args);
    }

}
