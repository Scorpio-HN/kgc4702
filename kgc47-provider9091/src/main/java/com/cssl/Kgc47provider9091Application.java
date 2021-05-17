package com.cssl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.cssl.mapper")

public class Kgc47provider9091Application {

    public static void main(String[] args) {
        SpringApplication.run(Kgc47provider9091Application.class, args);
    }

}
