package com.xdchen.order.dao;

import com.xdchen.order.dao.provider.OrderDaoProvider;
import com.xdchen.order.model.Order;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    @InsertProvider(type = OrderDaoProvider.class, method = "saveAll")
    void saveAll(@Param("list") List<Order> orders);
}
