package com.cssl.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${config.info.sb}")    // 注入配置中心中的config.info配置信息
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo() {

        return configInfo;
    }
}
