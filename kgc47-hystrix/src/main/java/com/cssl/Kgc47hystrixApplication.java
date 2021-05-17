package com.cssl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringBootApplication
public class Kgc47hystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(Kgc47hystrixApplication.class, args);
    }

}
