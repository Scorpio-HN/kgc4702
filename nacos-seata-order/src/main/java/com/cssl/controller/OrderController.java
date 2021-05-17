package com.cssl.controller;

import com.cssl.pojo.Order;
import com.cssl.service.OrderService;
import com.cssl.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/order/take")
    public Message takeOrder(Order order){
        Message msg = new Message();
        if(service.saveOrder(order)){
            msg.setCode(200);
            msg.setMsg("订单新增成功！");
        }else{
            msg.setCode(500);
            msg.setMsg("订单新增失败！");
        }
        return msg;
    }
}
