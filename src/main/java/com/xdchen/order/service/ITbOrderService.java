package com.xdchen.order.service;

import com.taobao.api.domain.Trade;
import com.taobao.api.request.TradesSoldGetRequest;
import com.taobao.api.request.TradesSoldIncrementGetRequest;
import com.xdchen.order.third.taobao.po.TbUser;

import java.util.List;

public interface ITbOrderService {
    long getTaobaoOrderTotal(TradesSoldGetRequest req, TbUser user);
    long getTaobaoIncrementOrderTotal(TradesSoldIncrementGetRequest req);
    List<Trade> getTradeList(TradesSoldGetRequest reqParams, TbUser user);
    List<Trade> getTradeIncrementList(TradesSoldIncrementGetRequest reqParams);
}
