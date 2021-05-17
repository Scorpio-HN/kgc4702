package com.cssl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients //使用fegin
@EnableCircuitBreaker
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3000)
public class Kgc47consumer8090Application {

    public static void main(String[] args) {
        SpringApplication.run(Kgc47consumer8090Application.class, args);
    }

}
