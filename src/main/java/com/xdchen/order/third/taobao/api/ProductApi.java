package com.xdchen.order.third.taobao.api;

import com.taobao.api.ApiException;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.ItemsOnsaleGetRequest;
import com.taobao.api.response.ItemsOnsaleGetResponse;
import com.xdchen.order.third.taobao.ClientFactory;
import com.xdchen.order.third.taobao.po.TbUser;

public class ProductApi extends BaseTbApi {
    public ProductApi(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    public ItemsOnsaleGetResponse itemsOnsaleGet(String keyword, String fields, long pageNo, long pageSize, TbUser user) {
        TaobaoClient client = clientFactory.getClient("json");
        ItemsOnsaleGetRequest req = new ItemsOnsaleGetRequest();
        req.setFields(fields);
        req.setQ(keyword);
        req.setPageNo(pageNo);
        req.setPageSize(pageSize);
        ItemsOnsaleGetResponse resp = null;
        try {
            resp = client.execute(req , user.getSessionKey());
            //检查sessionKey是否过期
            this.sessionIsValid(resp, user);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return resp;
    }
}
