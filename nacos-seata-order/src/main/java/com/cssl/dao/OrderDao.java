package com.cssl.dao;

import com.cssl.pojo.Order;

public interface OrderDao {

    public int insertOrder(Order order);

    public int updateOrder(String oid);
}
