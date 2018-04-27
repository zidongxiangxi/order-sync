package com.xdchen.order.service;

import com.taobao.api.request.TradesSoldGetRequest;
import com.taobao.api.request.TradesSoldIncrementGetRequest;
import com.taobao.api.response.*;
import com.xdchen.order.third.taobao.po.TbUser;

public interface ITopApiService {
    // 物流API
    LogisticsOrdersGetResponse getLogistic(String fields, long tid, TbUser user);
    LogisticsTraceSearchResponse traceSearch(long tid, String nick);
    LogisticsAddressSearchResponse addressSearch(String rdef, TbUser user);

    // 服务平台API
    VasOrderSearchResponse vasOrderSearch(String nick, String articleCode, String itemCode, long pageNo, long pageSize);
    VasSubscSearchResponse vasSubscSearch(String nick, String articleCode, String itemCode, long pageNo, long pageSize);
    FuwuSaleLinkGenResponse fuwuSaleLinkGen(String nick, String paramStr);

    // 店铺API
    ShopGetResponse getTaobaoSellerShop(String nick, String fields);

    // 消息服务API
    TmcUserPermitResponse tmcUserPermit(TbUser user);
    TmcUserCancelResponse tmcUserCancel(String nick);

    // 交易API
    TradesSoldGetResponse tradesSoldGet(TradesSoldGetRequest request, TbUser user);
    TradesSoldIncrementGetResponse tradesSoldIncrementGet(TradesSoldIncrementGetRequest request, TbUser user);
    TradeMemoUpdateResponse updateTradeMemo(long tid, long flag, TbUser user);
    TradeGetResponse getTradeGet(String fields, long tid, TbUser user);
    TradeFullinfoGetResponse getFullinfo(String fields, long tid, TbUser user);
    TraderatesGetResponse getTradeRate(String fields, String rateType, String role, Long tid, TbUser user);
    TradeReceivetimeDelayResponse tradeReceiveTimeDelay(long tid, long days);
    //退货列表
    RefundsReceiveGetResponse getRefundsReceive(String fields, String status, long pageSize, TbUser user);

    // 用户API
    UserSellerGetResponse getSellerInfo(String fields, TbUser user);

    // 商品API
    ItemsOnsaleGetResponse itemsOnsaleGet(String keyword, String fields, long pageNo, long pageSize, TbUser user);

    // 店铺会员管理API
    CrmServiceChannelShortlinkCreateResponse shortlinkCreate(String shortLinkName, String linkType, String shortLinkData, TbUser user);


}
