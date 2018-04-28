package com.xdchen.order.service.impl;

import com.taobao.api.request.TradesSoldGetRequest;
import com.taobao.api.request.TradesSoldIncrementGetRequest;
import com.taobao.api.response.*;
import com.xdchen.order.service.ITopApiService;
import com.xdchen.order.third.taobao.ClientFactory;
import com.xdchen.order.third.taobao.api.*;
import com.xdchen.order.model.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopApiServiceImpl implements ITopApiService {
    private CrmApi crmApi;
    private LogisticApi logisticApi;
    private ProductApi productApi;
    private ServerPlatformApi serverPlatformApi;
    private ShopApi shopApi;
    private TmcMessageApi tmcMessageApi;
    private TradeApi tradeApi;
    private UserApi userApi;

    @Autowired
    public TopApiServiceImpl(ClientFactory clientFactory) {
        crmApi = new CrmApi(clientFactory);
        logisticApi = new LogisticApi(clientFactory);
        productApi = new ProductApi(clientFactory);
        serverPlatformApi = new ServerPlatformApi(clientFactory);
        shopApi = new ShopApi(clientFactory);
        tmcMessageApi = new TmcMessageApi(clientFactory);
        tradeApi = new TradeApi(clientFactory);
        userApi = new UserApi(clientFactory);
    }

    @Override
    public LogisticsOrdersGetResponse getLogistic(String fields, long tid, TbUser user) {
        return logisticApi.getLogistic(fields, tid, user);
    }

    @Override
    public LogisticsTraceSearchResponse traceSearch(long tid, String nick) {
        return logisticApi.traceSearch(tid, nick);
    }

    @Override
    public LogisticsAddressSearchResponse addressSearch(String rdef, TbUser user) {
        return logisticApi.addressSearch(rdef, user);
    }

    @Override
    public VasOrderSearchResponse vasOrderSearch(String nick, String articleCode, String itemCode, long pageNo, long pageSize) {
        return serverPlatformApi.vasOrderSearch(nick, articleCode, itemCode, pageNo, pageSize);
    }

    @Override
    public VasSubscSearchResponse vasSubscSearch(String nick, String articleCode, String itemCode, long pageNo, long pageSize) {
        return serverPlatformApi.vasSubscSearch(nick, articleCode, itemCode, pageNo, pageSize);
    }

    @Override
    public FuwuSaleLinkGenResponse fuwuSaleLinkGen(String nick, String paramStr) {
        return serverPlatformApi.fuwuSaleLinkGen(nick, paramStr);
    }

    @Override
    public ShopGetResponse getTaobaoSellerShop(String nick, String fields) {
        return shopApi.shopGet(nick, fields);
    }

    @Override
    public TmcUserPermitResponse tmcUserPermit(TbUser user) {
        return tmcMessageApi.tmcUserPermit(user);
    }

    @Override
    public TmcUserCancelResponse tmcUserCancel(String nick) {
        return tmcMessageApi.tmcUserCancel(nick);
    }

    @Override
    public TradesSoldGetResponse tradesSoldGet(TradesSoldGetRequest request, TbUser user) {
        return tradeApi.tradesSoldGet(request, user);
    }

    @Override
    public TradesSoldIncrementGetResponse tradesSoldIncrementGet(TradesSoldIncrementGetRequest request, TbUser user) {
        return tradeApi.tradesSoldIncrementGet(request, user);
    }

    @Override
    public TradeMemoUpdateResponse updateTradeMemo(long tid, long flag, TbUser user) {
        return tradeApi.updateTradeMemo(tid, flag, user);
    }

    @Override
    public TradeGetResponse getTradeGet(String fields, long tid, TbUser user) {
        return tradeApi.getTradeGet(fields, tid, user);
    }

    @Override
    public TradeFullinfoGetResponse getFullinfo(String fields, long tid, TbUser user) {
        return tradeApi.getFullinfo(fields, tid, user);
    }

    @Override
    public TraderatesGetResponse getTradeRate(String fields, String rateType, String role, Long tid, TbUser user) {
        return tradeApi.getTradeRate(fields, rateType, role, tid, user);
    }

    @Override
    public TradeReceivetimeDelayResponse tradeReceiveTimeDelay(long tid, long days) {
        return tradeApi.tradeReceiveTimeDelay(tid, days);
    }

    @Override
    public RefundsReceiveGetResponse getRefundsReceive(String fields, String status, long pageSize, TbUser user) {
        return tradeApi.getRefundsReceive(fields, status, pageSize, user);
    }

    @Override
    public UserSellerGetResponse getSellerInfo(String fields, TbUser user) {
        return userApi.getSellerInfo(fields, user);
    }

    @Override
    public ItemsOnsaleGetResponse itemsOnsaleGet(String keyword, String fields, long pageNo, long pageSize, TbUser user) {
        return productApi.itemsOnsaleGet(keyword, fields, pageNo, pageSize, user);
    }

    @Override
    public CrmServiceChannelShortlinkCreateResponse shortlinkCreate(String shortLinkName, String linkType, String shortLinkData, TbUser user) {
        return crmApi.shortlinkCreate(shortLinkName, linkType, shortLinkData, user);
    }
}
