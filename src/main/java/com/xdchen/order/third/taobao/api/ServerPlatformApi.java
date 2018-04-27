package com.xdchen.order.third.taobao.api;

import com.taobao.api.ApiException;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.FuwuSaleLinkGenRequest;
import com.taobao.api.request.VasOrderSearchRequest;
import com.taobao.api.request.VasSubscSearchRequest;
import com.taobao.api.response.FuwuSaleLinkGenResponse;
import com.taobao.api.response.VasOrderSearchResponse;
import com.taobao.api.response.VasSubscSearchResponse;
import com.xdchen.order.third.taobao.ClientFactory;

public class ServerPlatformApi extends BaseTbApi {
    public ServerPlatformApi(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    public VasOrderSearchResponse vasOrderSearch(String nick, String articleCode, String itemCode, long pageNo, long pageSize) {
		TaobaoClient client = clientFactory.getClient("json");
		VasOrderSearchRequest req = new VasOrderSearchRequest();

		req.setNick(nick);
		req.setArticleCode(articleCode);
		req.setPageSize(pageSize);
		req.setPageNo(pageNo);

		req.setItemCode(itemCode);
		VasOrderSearchResponse resp = null;
		try {
			resp = client.execute(req);
			if (null != resp && (resp.getErrorCode().equals("7") || resp.getSubMsg().contains("This ban will last for"))) {
				Thread.sleep(1500);
				resp = client.execute(req);
			}
		} catch (ApiException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
            e.printStackTrace();
        }
        return resp;
	}

	public VasSubscSearchResponse vasSubscSearch(String nick, String articleCode, String itemCode, long pageNo, long pageSize) {
		TaobaoClient client = clientFactory.getClient("json");
		VasSubscSearchRequest req = new VasSubscSearchRequest();

		req.setArticleCode(articleCode);
		req.setPageSize(pageSize);
		req.setPageNo(pageNo);
		req.setStatus(1L);

		if (null != nick) {
			req.setNick(nick);
		}
		if (null != itemCode) {
			req.setItemCode(itemCode);
		}
		VasSubscSearchResponse resp = null;
		try {
			resp = client.execute(req);
			if (null != resp && null != resp.getErrorCode() &&
					(resp.getErrorCode().equals("7") || resp.getSubMsg().contains("This ban will last for"))) {
				Thread.sleep(1500);
				resp = client.execute(req);
			}
		} catch (ApiException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
            e.printStackTrace();
        }
        return resp;
	}

	public FuwuSaleLinkGenResponse fuwuSaleLinkGen(String nick, String paramStr) {
		TaobaoClient client = clientFactory.getClient("json");
		FuwuSaleLinkGenRequest req = new FuwuSaleLinkGenRequest();
		req.setNick(nick);
		req.setParamStr(paramStr);

		try {
            return client.execute(req);
		} catch (ApiException e) {
			e.printStackTrace();
			return null;
		}
	}
}
