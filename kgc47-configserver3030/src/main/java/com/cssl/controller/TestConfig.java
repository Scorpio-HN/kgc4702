package com.cssl.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RefreshScope //自动刷新
@RestController
public class TestConfig {

    @Value("${mytest}")
    private String info;

    @GetMapping("/getInfo")
    public String getInfo(){

        System.out.println("从config-server服务器上获取配置信息："+info);

        return info;
    }

}
