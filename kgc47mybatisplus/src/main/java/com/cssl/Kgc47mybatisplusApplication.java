package com.cssl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.cssl.mapper")
@SpringBootApplication
public class Kgc47mybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(Kgc47mybatisplusApplication.class, args);
    }

}
