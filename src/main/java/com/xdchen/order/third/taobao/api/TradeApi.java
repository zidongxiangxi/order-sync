package com.xdchen.order.third.taobao.api;

import com.taobao.api.ApiException;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.*;
import com.taobao.api.response.*;
import com.xdchen.order.third.taobao.ClientFactory;
import com.xdchen.order.model.TbUser;

import java.util.Calendar;

public class TradeApi extends BaseTbApi {
	public TradeApi(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	/**
	 * @info 搜索当前会话用户作为卖家已卖出的交易数据（只能获取到三个月以内的交易信息）
	 * @param request
	 * @param user
	 * @return
	 */
	public TradesSoldGetResponse tradesSoldGet(TradesSoldGetRequest request, TbUser user) {
		TaobaoClient client = clientFactory.getClient("json");
		TradesSoldGetRequest req = new TradesSoldGetRequest();
		request.setType("fixed,auction,,step,guarantee_trade,independent_simple_trade,independent_shop_trade,auto_delivery,ec,cod,fenxiao,game_equipment,shopex_trade,netcn_trade,external_trade,instant_trade,b2c_cod,hotel_trade,super_market_trade,super_market_cod_trade,taohua,waimai,nopaid,tmall_i18n,nopaid");

		TradesSoldGetResponse resp = null;
		try {
			resp = client.execute(req, user.getSessionKey());
			//检查sessionKey是否过期
			this.sessionIsValid(resp, user);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return resp;
	}

	/**
	 * @info 增量搜索当前会话用户作为卖家已卖出的交易数据
	 * @param request
	 * @param user
	 * @return
	 */
	public TradesSoldIncrementGetResponse tradesSoldIncrementGet(TradesSoldIncrementGetRequest request, TbUser user) {
		TaobaoClient client = clientFactory.getClient("json");
		request.setType("fixed,auction,,step,guarantee_trade,independent_simple_trade,independent_shop_trade,auto_delivery,ec,cod,fenxiao,game_equipment,shopex_trade,netcn_trade,external_trade,instant_trade,b2c_cod,hotel_trade,super_market_trade,super_market_cod_trade,taohua,waimai,nopaid,tmall_i18n,nopaid");

		TradesSoldIncrementGetResponse resp = null;
		try {
			resp = client.execute(request, user.getSessionKey());
			//检查sessionKey是否过期
			this.sessionIsValid(resp, user);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return resp;
	}

	public TradeMemoUpdateResponse updateTradeMemo(long tid, long flag, TbUser user) {
		TaobaoClient client = clientFactory.getClient("json");
		TradeMemoUpdateRequest req = new TradeMemoUpdateRequest();
		req.setTid(tid);
		req.setFlag(flag);

		TradeMemoUpdateResponse resp = null;
		try {
			resp = client.execute(req, user.getSessionKey());
			//检查sessionKey是否过期
			this.sessionIsValid(resp, user);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return resp;
	}

	/**
	 * 获取单笔交易的部分信息（性能高）
	 */
	public TradeGetResponse getTradeGet(String fields, long tid, TbUser user) {
		TaobaoClient client = clientFactory.getClient("json");
		TradeGetRequest req = new TradeGetRequest();
		req.setFields(fields);
		req.setTid(tid);

		TradeGetResponse resp = null;
		try {
			resp = client.execute(req, user.getSessionKey());
			//检查sessionKey是否过期
			this.sessionIsValid(resp, user);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return resp;
	}

	/**
	 * 获取单笔交易的详细信息
	 */
	public TradeFullinfoGetResponse getFullinfo(String fields, long tid, TbUser user) {
		TaobaoClient client = clientFactory.getClient("json");
		TradeFullinfoGetRequest req = new TradeFullinfoGetRequest();
		req.setFields(fields);
		req.setTid(tid);

		TradeFullinfoGetResponse resp = null;
		try {
			resp = client.execute(req, user.getSessionKey());
			//检查sessionKey是否过期
			this.sessionIsValid(resp, user);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return resp;
	}

	/**
	 * 搜索评价信息
	 */
	public TraderatesGetResponse getTradeRate(String fields, String rateType, String role, Long tid, TbUser user) {
		TaobaoClient client = clientFactory.getClient("json");
		TraderatesGetRequest req = new TraderatesGetRequest();
		req.setFields(fields);
		req.setRateType(rateType);
		req.setRole(role);
		req.setTid(tid);
		TraderatesGetResponse resp = null;
		try {
			resp = client.execute(req, user.getSessionKey());
			//检查sessionKey是否过期
			this.sessionIsValid(resp, user);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return resp;
	}

	/**
	 * 延长交易收货时间
	 *
	 */
	public TradeReceivetimeDelayResponse tradeReceiveTimeDelay(long tid, long days) {
		TaobaoClient client = clientFactory.getClient("json");
		TradeReceivetimeDelayRequest req = new TradeReceivetimeDelayRequest();
		req.setTid(tid);
		req.setDays(days);
		req.setTimestamp(System.currentTimeMillis());

		TradeReceivetimeDelayResponse resp = null;
		try {
			resp = client.execute(req);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return resp;
	}

	public RefundsReceiveGetResponse getRefundsReceive(String fields, String status, long pageSize, TbUser user) {
		TaobaoClient client = clientFactory.getClient("json");
		RefundsReceiveGetRequest req = new RefundsReceiveGetRequest();
		req.setFields(fields);
		req.setStatus(status);
		req.setPageNo(1L);
		req.setPageSize(pageSize);
		req.setUseHasNext(false);
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(System.currentTimeMillis());
		cal.add(Calendar.HOUR_OF_DAY, -1);
		req.setStartModified(cal.getTime());
		RefundsReceiveGetResponse resp = null;
		
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
