package com.xdchen.order.service.impl;

import com.xdchen.order.dao.OrderMapper;
import com.xdchen.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalOrderService {
    private final OrderMapper orderMapper;

    @Autowired
    public LocalOrderService(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public void saveOrders(List<Order> orderList) {
        orderMapper.saveAll(orderList);
    }
}
