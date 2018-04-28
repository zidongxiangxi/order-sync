package com.xdchen.order.service;

import com.xdchen.order.model.Order;
import com.xdchen.order.model.BaseThirdUser;

import java.util.Date;
import java.util.List;

public interface IImportOrderService {
    List<Order> importByUser(BaseThirdUser user, Date start, Date end, boolean isInc);
    long getTotal(BaseThirdUser baseThirdUser, Date start, Date end, boolean isInc);
}
