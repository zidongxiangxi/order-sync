package com.xdchen.order.third.taobao.api;

import com.taobao.api.TaobaoResponse;
import com.xdchen.order.third.taobao.ClientFactory;
import com.xdchen.order.third.taobao.exception.InvalidSessionException;
import com.xdchen.order.third.taobao.po.TbUser;

public class BaseTbApi {
    protected ClientFactory clientFactory;

    void sessionIsValid(TaobaoResponse response, TbUser user) {
        if (null != response && response.getErrorCode() != null && response.getErrorCode().equals("27")) {
            throw new InvalidSessionException(user.getUserId());
        }
    }
}
