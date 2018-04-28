package com.xdchen.order.service.impl;

import com.taobao.api.domain.Shipping;
import com.taobao.api.domain.Trade;
import com.taobao.api.request.TradesSoldGetRequest;
import com.taobao.api.request.TradesSoldIncrementGetRequest;
import com.xdchen.order.model.Order;
import com.xdchen.order.service.IImportOrderService;
import com.xdchen.order.service.ITbOrderService;
import com.xdchen.order.third.BaseThirdUser;
import com.xdchen.order.third.taobao.TaobaoRespFieldsConfig;
import com.xdchen.order.third.taobao.po.EOrderStatusCode;
import com.xdchen.order.third.taobao.po.TbUser;
import com.xdchen.order.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TbImportOrderService implements IImportOrderService {
    private static final long DEFAULT_PAGE_SIZE = 50;
    private final ITbOrderService orderService;

    @Autowired
    public TbImportOrderService(ITbOrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public List<Order> importByUser(BaseThirdUser baseThirdUser, Date start, Date end, boolean isInc) {
        List<Order> orders = new ArrayList<>();
        if (!(baseThirdUser instanceof TbUser)) {
            return orders;
        }
        TbUser user = (TbUser) baseThirdUser;
        try {
            long total = this.getTotal(user, start, end, isInc);
            if (total == 0) {
                return orders;
            }
            long totalPage = total / DEFAULT_PAGE_SIZE + 1;
            List<Trade> trades;
            if (isInc) {
                trades = this.getTradesIncrement(user, start, end, totalPage, total);
            } else {
                trades = this.getTrades(user, start, end, totalPage, total);
            }
            orders = this.transformTradeToOrder(trades, user);
        } catch (Exception e) {
            // TODO: Logger
        }
        return orders;
    }

    @Override
    public long getTotal(BaseThirdUser baseThirdUser, Date start, Date end, boolean isInc) {
        if (!(baseThirdUser instanceof TbUser)) {
            return 0L;
        }
        TbUser user = (TbUser) baseThirdUser;
        if (isInc) {
            TradesSoldIncrementGetRequest request = new TradesSoldIncrementGetRequest();
            request.setStartModified(start);
            request.setEndModified(end);
            request.setStatus(EOrderStatusCode.WAIT_BUYER_CONFIRM_GOODS.toString());
            request.setFields(TaobaoRespFieldsConfig.ORDER_ID);
            request.setPageSize(1L);
            request.setPageNo(1L);
            return orderService.getTaobaoIncrementOrderTotal(request, user);
        } else {
            TradesSoldGetRequest request = new TradesSoldGetRequest();
            request.setStartCreated(start);
            request.setEndCreated(end);
            request.setStatus(EOrderStatusCode.WAIT_BUYER_CONFIRM_GOODS.toString());
            request.setFields(TaobaoRespFieldsConfig.ORDER_ID);
            request.setPageSize(1L);
            request.setPageNo(1L);
            return orderService.getTaobaoOrderTotal(request, user);
        }
    }

    private List<Trade> getTrades(TbUser user, Date start, Date end, long totalPage, long total) {
        TradesSoldIncrementGetRequest request = new TradesSoldIncrementGetRequest();
        request.setStartModified(start);
        request.setEndModified(end);
        request.setStatus(EOrderStatusCode.WAIT_BUYER_CONFIRM_GOODS.toString());
        request.setFields(TaobaoRespFieldsConfig.ORDER_IMPORT_FIELDS);
        request.setPageSize(DEFAULT_PAGE_SIZE);

        List<Trade> trades = new ArrayList<>((int) total);
        while (totalPage >= 1) {
            request.setPageNo(totalPage);
            trades.addAll(orderService.getTradeIncrementList(request, user));
            totalPage--;
        }
        return trades;
    }

    private List<Trade> getTradesIncrement(TbUser user, Date start, Date end, long totalPage, long total) {
        TradesSoldGetRequest request = new TradesSoldGetRequest();
        request.setStartCreated(start);
        request.setEndCreated(end);
        request.setStatus(EOrderStatusCode.WAIT_BUYER_CONFIRM_GOODS.toString());
        request.setFields(TaobaoRespFieldsConfig.ORDER_IMPORT_FIELDS);
        request.setPageSize(DEFAULT_PAGE_SIZE);

        List<Trade> trades = new ArrayList<>((int) total);
        while (totalPage >= 1) {
            request.setPageNo(totalPage);
            trades.addAll(orderService.getTradeList(request, user));
            totalPage--;
        }
        return trades;
    }

    private List<Order> transformTradeToOrder(List<Trade> trades, TbUser user) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Order> orders = new ArrayList<>(trades.size());
        for (Trade trade : trades) {
            Order order = new Order();
            List<Shipping> shippingList = orderService.getOrderLogisticInfo(trade.getTid(), TaobaoRespFieldsConfig.LOGISTICS_ORDER_FIELDS, user);
            if (shippingList.size() > 0) {
                order.setKuaidiCom(shippingList.get(0).getOutSid());
                order.setTbKuaidiCom(shippingList.get(0).getCompanyName());
                order.setKuaidiCom(CommonUtil.getCompanyCode(shippingList.get(0).getCompanyName()).toLowerCase());
            }
            order.setUserId(user.getUserId());
            order.setIsPayed(user.getSmsBalance());
            order.setOrderId(String.valueOf(trade.getTid()));
            order.setBuyerMobile(trade.getReceiverMobile());
            order.setRecAddr(trade.getReceiverState() + trade.getReceiverCity() + trade.getReceiverDistrict());

            order.setCargo(trade.getOrders().get(0).getTitle());
            order.setConsignTime(sdf.format(trade.getConsignTime()));
            String common = "寄往" + trade.getReceiverCity() + "；" +
                    "收货人：" + trade.getReceiverName() + "；" +
                    "旺旺：" + trade.getBuyerNick();
            order.setComment(common);

            order.setNick(user.getNick());
            order.setCreated(sdf.format(trade.getCreated()));
            order.setPayment(trade.getPayment());
            order.setRecState(trade.getReceiverState());
            if (StringUtils.isEmpty(trade.getReceiverCity())) {
                order.setRecCity(trade.getReceiverDistrict());
            } else {
                order.setRecCity(trade.getReceiverCity());
            }
            order.setRecDistrict(trade.getReceiverDistrict());
            orders.add(order);
        }
        return orders;
    }
}
