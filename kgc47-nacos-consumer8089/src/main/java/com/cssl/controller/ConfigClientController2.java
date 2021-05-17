package com.cssl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController2 {
    @Autowired
    private ConfigurableApplicationContext config;

    @GetMapping("/config")
    public String config(){
        String test = config.getEnvironment().getProperty("config.info.sb");
        return test;
    }
}
