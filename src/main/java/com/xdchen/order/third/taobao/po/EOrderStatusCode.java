package com.xdchen.order.third.taobao.po;

public enum EOrderStatusCode {
	TRADE_NO_CREATE_PAY("TRADE_NO_CREATE_PAY", "没有创建支付宝交易"), //
	WAIT_BUYER_PAY("WAIT_BUYER_PAY", "等待买家付款"), //
	WAIT_SELLER_SEND_GOODS("WAIT_SELLER_SEND_GOODS", "等待卖家发货"), //
	SELLER_CONSIGNED_PART("SELLER_CONSIGNED_PART", "卖家部分发货"), //
	WAIT_BUYER_CONFIRM_GOODS("WAIT_BUYER_CONFIRM_GOODS", "卖家已发货"), //
	TRADE_BUYER_SIGNED("TRADE_BUYER_SIGNED", "买家已签收"), //
	TRADE_FINISHED("TRADE_FINISHED", "交易成功"), //
	TRADE_CLOSED("TRADE_CLOSED", "交易关闭"), //
	TRADE_CLOSED_BY_TAOBAO("TRADE_CLOSED_BY_TAOBAO", "交易被淘宝关闭"), //
	WAIT_SELLER_CONFIRM_GOODS("WAIT_SELLER_CONFIRM_GOODS", "买家已经退货，等待卖家确认收货");

	private final String val;
	private final String name;

	private EOrderStatusCode(String val, String name) {
		this.val = val;
		this.name = name;
	}

	@Override
	public String toString() {
		return val;
	}

	public String toName() {
		return name;
	}
}
