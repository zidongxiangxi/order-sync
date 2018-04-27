package com.xdchen.order.third.taobao.api;

import com.taobao.api.ApiException;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.ShopGetRequest;
import com.taobao.api.response.ShopGetResponse;
import com.xdchen.order.third.taobao.ClientFactory;

public class ShopApi extends BaseTbApi {
    public ShopApi(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    public ShopGetResponse shopGet(String nick, String fields) {
        TaobaoClient client = clientFactory.getClient("json");
        ShopGetRequest req = new ShopGetRequest();
        req.setFields(fields);
        req.setNick(nick);
        try {
            return client.execute(req);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return null;
    }
}
