package com.xdchen.order.third.taobao;

public class TaobaoRespFieldsConfig {
	public final static String ORDER_ID = "tid";
	public final static String ORDER_IMPORT_FIELDS =
		"tid, created, consign_time, receiver_state, receiver_city, receiver_district, receiver_address, receiver_zip, receiver_mobile, receiver_name, buyer_nick, orders.title, payment";
	public final static String LOGISTICS_ORDER_FIELDS = "out_sid,company_name";
	public final static String ORDER_REQUEST_FIELDS = "tid, buyer_nick, created, receiver_mobile, num_iid, receiver_name";
	public final static String ORDER_CONTACTS_FIELDS = "tid, buyer_nick, created, payment, receiver_city, receiver_mobile, receiver_name, receiver_state, orders.title, orders.num_iid";
	public final static String ORDER_URGE_FIELDS = "tid, receiver_mobile, receiver_name, created, buyer_nick, payment";
}
