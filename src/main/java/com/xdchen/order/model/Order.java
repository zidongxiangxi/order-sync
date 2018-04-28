package com.xdchen.order.model;

public class Order {
    private Long userId;
    private String nick = "";
    private String kuaidiCom = ""; // 快递公司名称
    private String kuaidiNum = ""; // 快递单号
    private String orderId = ""; // 订单号
    private String cargo = ""; // 货物名称
    private String recAddr = ""; // 收货地址
    private String buyerMobile = ""; // 买家电话
    private String comment = ""; // 公司名称
    private String consignTime = "";	// 发货时间
    private String created = "";	// 交易创建时间
    private String tbKuaidiCom = "";	// 快递公司名称（淘宝）
    private String payment;	//实付金额
    private Integer isPayed = 0;
    private String recState = ""; // 收件人省
    private String recCity = ""; // 收件人市
    private String recDistrict = ""; // 收件人区

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getKuaidiCom() {
        return kuaidiCom;
    }

    public void setKuaidiCom(String kuaidiCom) {
        this.kuaidiCom = kuaidiCom;
    }

    public String getKuaidiNum() {
        return kuaidiNum;
    }

    public void setKuaidiNum(String kuaidiNum) {
        this.kuaidiNum = kuaidiNum;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getRecAddr() {
        return recAddr;
    }

    public void setRecAddr(String recAddr) {
        this.recAddr = recAddr;
    }

    public String getBuyerMobile() {
        return buyerMobile;
    }

    public void setBuyerMobile(String buyerMobile) {
        this.buyerMobile = buyerMobile;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getConsignTime() {
        return consignTime;
    }

    public void setConsignTime(String consignTime) {
        this.consignTime = consignTime;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getTbKuaidiCom() {
        return tbKuaidiCom;
    }

    public void setTbKuaidiCom(String tbKuaidiCom) {
        this.tbKuaidiCom = tbKuaidiCom;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Integer getIsPayed() {
        return isPayed;
    }

    public void setIsPayed(Integer isPayed) {
        this.isPayed = isPayed;
    }

    public String getRecState() {
        return recState;
    }

    public void setRecState(String recState) {
        this.recState = recState;
    }

    public String getRecCity() {
        return recCity;
    }

    public void setRecCity(String recCity) {
        this.recCity = recCity;
    }

    public String getRecDistrict() {
        return recDistrict;
    }

    public void setRecDistrict(String recDistrict) {
        this.recDistrict = recDistrict;
    }
}
