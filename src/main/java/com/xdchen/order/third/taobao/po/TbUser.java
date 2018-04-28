package com.xdchen.order.third.taobao.po;

import com.xdchen.order.third.BaseThirdUser;

public class TbUser extends BaseThirdUser {
    private long userId;
    private String sessionKey;
    private String nick;
    private int smsBalance;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getSmsBalance() {
        return smsBalance;
    }

    public void setSmsBalance(int smsBalance) {
        this.smsBalance = smsBalance;
    }
}
