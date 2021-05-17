package com.cssl.service.impl;

import com.cssl.dao.OrderDao;
import com.cssl.feign.FeignAccountClient;
import com.cssl.pojo.Order;
import com.cssl.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private FeignAccountClient client;

    @GlobalTransactional
    @Override
    public boolean saveOrder(Order order) {
        log.info("====开始新增订单====");
        order.setOid(UUID.randomUUID().toString());
        int c1 = orderDao.insertOrder(order);
        log.info("====结束新增订单====");

        log.info("====开始修改账户====");
        int c2 = client.update(order.getMoney(),order.getUser_id());
        log.info("====结束修改账户====");
         //int i=1/0;
        log.info("====开始修改订单====");
        int c3 = orderDao.updateOrder(order.getOid());
        log.info("====结束修改订单====");

        if(c1>=1 && c3>=1 &&c2>=1){
            return true;
        }
        return false;
    }
}
