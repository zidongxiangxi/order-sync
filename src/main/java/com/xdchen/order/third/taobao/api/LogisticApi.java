package com.xdchen.order.third.taobao.api;

import com.taobao.api.ApiException;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.LogisticsAddressSearchRequest;
import com.taobao.api.request.LogisticsOrdersGetRequest;
import com.taobao.api.request.LogisticsTraceSearchRequest;
import com.taobao.api.response.LogisticsAddressSearchResponse;
import com.taobao.api.response.LogisticsOrdersGetResponse;
import com.taobao.api.response.LogisticsTraceSearchResponse;
import com.xdchen.order.third.taobao.ClientFactory;
import com.xdchen.order.third.taobao.po.TbUser;

public class LogisticApi extends BaseTbApi {
    public LogisticApi(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    // 下载当前在途订单
    public LogisticsOrdersGetResponse getLogistic(String fields, long tid, TbUser user)	{
        TaobaoClient client = clientFactory.getClient("json");
        LogisticsOrdersGetRequest req = new LogisticsOrdersGetRequest();
        req.setFields(fields);
        req.setTid(tid);
        LogisticsOrdersGetResponse resp = null;
        try {
            resp = client.execute(req, user.getSessionKey());
            //检查sessionKey是否过期
            this.sessionIsValid(resp, user);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return resp;
    }

    public LogisticsTraceSearchResponse traceSearch(long tid, String nick) {
        TaobaoClient client = clientFactory.getClient("json");
        LogisticsTraceSearchRequest req = new LogisticsTraceSearchRequest();
        LogisticsTraceSearchResponse resp = null;
        req.setTid(tid);
        req.setSellerNick(nick);
        try {
            resp = client.execute(req);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return resp;
    }

    public LogisticsAddressSearchResponse addressSearch(String rdef, TbUser user) {
        TaobaoClient client = clientFactory.getClient("json");
        LogisticsAddressSearchRequest req = new LogisticsAddressSearchRequest();
        if (null != rdef) {
            req.setRdef(rdef);
        }
        LogisticsAddressSearchResponse resp = null;
        try {
            resp = client.execute(req, user.getSessionKey());
            //检查sessionKey是否过期
            this.sessionIsValid(resp, user);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return resp;
    }
}
