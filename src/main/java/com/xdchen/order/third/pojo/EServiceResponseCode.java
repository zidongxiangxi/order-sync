package com.xdchen.order.third.pojo;

public enum EServiceResponseCode {
	C200("200","成功"),//成功
	C201("201","无效操作"),//成功
	C401("401","参数错误"),//成功
	C402("402","未指明服务"),//未指明服务
	C500("500","服务器错误"),//服务器错误
	C404("404","找不到"),//找不到数据
	C415("415","需要授权登陆"),//需要授权登陆
	C400("400","未登录");//未登录

	private final String name;
	private final String zhName;

	private EServiceResponseCode(String name, String zhName) {
		this.name = name;
		this.zhName = zhName;
	}

	@Override
	public String toString(){
		return name;
	}

	public String toZhName(){
		return zhName;
	}


}
