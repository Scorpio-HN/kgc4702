package com.cssl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableZuulProxy

public class Kgc47springcloudzuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(Kgc47springcloudzuulApplication.class, args);
    }

}
