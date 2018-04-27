package com.xdchen.order.third.taobao.api;

import com.taobao.api.ApiException;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TopSecretGetRequest;
import com.taobao.api.request.UserSellerGetRequest;
import com.taobao.api.response.TopSecretGetResponse;
import com.taobao.api.response.UserSellerGetResponse;
import com.xdchen.order.third.taobao.ClientFactory;
import com.xdchen.order.third.taobao.exception.InvalidSessionException;
import com.xdchen.order.third.taobao.po.TbUser;

public class UserApi extends BaseTbApi {
	public UserApi(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	public UserSellerGetResponse getSellerInfo(String fields, TbUser user) {
		TaobaoClient client = clientFactory.getClient("json");
		UserSellerGetRequest req = new UserSellerGetRequest();
		UserSellerGetResponse resp = null;
		req.setFields(fields);
		try {
			resp = client.execute(req, user.getSessionKey());
			if (null != resp && resp.getErrorCode() != null && resp.getErrorCode().equals("27")) {
//				TaobaoUserService.logger.error("TOP_API|EXCEPTION_27|SESSIONKEY|UserApiService.getSellerInfo|" + user.getUserId() + "|" + user.getNick() + "|" + user.getSessionKey());
				//检查sessionKey是否过期
				throw new InvalidSessionException(user.getUserId());
			}
			return resp;
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return resp;
	}
	
	public TopSecretGetResponse getSecret(TbUser user) {
		TaobaoClient client =  clientFactory.getHttpsClient("json");
		TopSecretGetRequest req = new TopSecretGetRequest();
		req.setSecretVersion(1L);
		req.setRandomNum(clientFactory.getTaobaoConfig().getTopToken());
		try {
			TopSecretGetResponse resp = client.execute(req, user.getSessionKey());
			if (null != resp && resp.getErrorCode() != null && resp.getErrorCode().equals("27")) {
//				TaobaoUserService.logger.error("TOP_API|EXCEPTION_27|SESSIONKEY|UserApiService.getSecret|" + user.getUserId() + "|" + user.getNick() + "|" + user.getSessionKey());
				throw new InvalidSessionException(user.getUserId());
			}
			return resp;
		} catch (ApiException e) {
			e.printStackTrace();
			return null;
		}
	}
}
