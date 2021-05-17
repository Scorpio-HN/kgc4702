package com.cssl;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Component;

@Component
public class ExceptionHandler {


    public static String callBack(String name, String pass, BlockException be){
        System.out.println("异常信息："+be.getMessage());
        System.out.println("违法热点请求规则...........："+name);

        return "违反热点规则";

    }
}
