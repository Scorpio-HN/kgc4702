package com.cssl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.cssl.mapper")
public class Dubbokgc47providerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Dubbokgc47providerApplication.class, args);
    }

}
