package com.xdchen.order.service.impl;

import com.taobao.api.domain.Trade;
import com.taobao.api.request.TradesSoldGetRequest;
import com.taobao.api.request.TradesSoldIncrementGetRequest;
import com.taobao.api.response.TradesSoldGetResponse;
import com.taobao.api.response.TradesSoldIncrementGetResponse;
import com.xdchen.order.service.ITbOrderService;
import com.xdchen.order.service.ITopApiService;
import com.xdchen.order.third.ThirdApiException;
import com.xdchen.order.third.taobao.TaobaoRespFieldsConfig;
import com.xdchen.order.third.taobao.po.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbOrderService implements ITbOrderService {
    private final ITopApiService topApiService;

    @Autowired
    public TbOrderService(ITopApiService topApiService) {
        this.topApiService = topApiService;
    }

    /**
     * 获取本次查询的总数
     * @param req
     * @return
     */
    @SuppressWarnings("rawtypes")
    @Override
    public long getTaobaoOrderTotal(TradesSoldGetRequest req, TbUser user) {
        req.setFields(TaobaoRespFieldsConfig.ORDER_ID);
        TradesSoldGetResponse tbresp = topApiService.tradesSoldGet(req, user);
        if (null == tbresp) {
            throw new ThirdApiException("淘宝接口调用出错");
        }

        if (tbresp.getErrorCode() != null) {
            throw new ThirdApiException("淘宝接口调用出错|" + tbresp.getErrorCode());
        }
        return tbresp.getTotalResults();
    }

    /**
     * 获取本次增量查询的总数
     * @param req
     * @return
     */
    @SuppressWarnings("rawtypes")
    @Override
    public long getTaobaoIncrementOrderTotal(TradesSoldIncrementGetRequest req) {
        req.setFields(TaobaoRespFieldsConfig.ORDER_ID);
        TradesSoldIncrementGetResponse tbresp = topApiService.tradesSoldIncrementGet(req, null);

        if (null == tbresp) {
            throw new ThirdApiException("淘宝接口调用出错");
        }

        if (tbresp.getErrorCode() != null) {
            throw new ThirdApiException("淘宝接口调用出错|" + tbresp.getErrorCode());
        }
        return tbresp.getTotalResults();

    }

    /**
     * 获取本次查询的TradeList对象
     * @param reqParams
     * @return
     */
    @Override
    public List<Trade> getTradeList(TradesSoldGetRequest reqParams, TbUser user) {
        TradesSoldGetResponse tbresp = null;
        int errCount = 0;
        do {
            tbresp = topApiService.tradesSoldGet(reqParams, user);
            if (null == tbresp) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ignored) {
                }
                errCount++;
            }
        } while (null == tbresp && errCount < 5);

        if (null == tbresp || null == tbresp.getErrorCode()) {
            return null;
        }
        return tbresp.getTrades();
    }

    /**
     * 获取本次增量查询的TradeList对象
     * @param reqParams
     * @return
     */
    @Override
    public List<Trade> getTradeIncrementList(TradesSoldIncrementGetRequest reqParams) {
        TradesSoldIncrementGetResponse tbresp = null;
        int errCount = 0;
        do {
            tbresp = topApiService.tradesSoldIncrementGet(reqParams, null);
            if (null == tbresp) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ignored) {
                }
                errCount++;
            }
        } while (null == tbresp && errCount < 5);

        if (null == tbresp || null == tbresp.getErrorCode()) {
            return null;
        }
        return tbresp.getTrades();
    }
}
