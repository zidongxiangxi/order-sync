package com.xdchen.order.third.taobao.api;

import com.taobao.api.ApiException;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TmcUserCancelRequest;
import com.taobao.api.request.TmcUserPermitRequest;
import com.taobao.api.response.TmcUserCancelResponse;
import com.taobao.api.response.TmcUserPermitResponse;
import com.xdchen.order.third.taobao.ClientFactory;
import com.xdchen.order.model.TbUser;

public class TmcMessageApi extends BaseTbApi {
	public TmcMessageApi(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	public TmcUserPermitResponse tmcUserPermit(TbUser user) {
		TaobaoClient client = clientFactory.getClient("json");
		TmcUserPermitRequest req = new TmcUserPermitRequest();
		try {
			TmcUserPermitResponse resp = client.execute(req, user.getSessionKey());
			//检查sessionKey是否过期
			this.sessionIsValid(resp, user);
			return resp;
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return null;
	}

	public TmcUserCancelResponse tmcUserCancel(String nick) {
		TaobaoClient client = clientFactory.getClient("json");
		TmcUserCancelRequest req = new TmcUserCancelRequest();
		req.setNick(nick);
		try {
			return client.execute(req);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return null;
	}
}
