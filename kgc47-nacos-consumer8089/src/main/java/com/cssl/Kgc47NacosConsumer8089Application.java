package com.cssl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class Kgc47NacosConsumer8089Application {

    public static void main(String[] args) {
        SpringApplication.run(Kgc47NacosConsumer8089Application.class, args);
    }

}
