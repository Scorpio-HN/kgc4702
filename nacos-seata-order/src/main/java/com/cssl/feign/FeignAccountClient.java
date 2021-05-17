package com.cssl.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "seata-account")
public interface FeignAccountClient {

    @GetMapping("/account/update")
    public int update(@RequestParam int money, @RequestParam int user_id);

}
