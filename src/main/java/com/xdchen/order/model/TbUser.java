package com.xdchen.order.model;

public class TbUser extends BaseThirdUser {
    private String sessionKey;
    // 授权信息
    private Long expiresin;
    private Long expiresinR1;
    private Long expiresinR2;
    private Long expiresinW1;
    private Long expiresinW2;
    private Long reexpiresin;
    private Long authorizeTime;

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public Long getExpiresin() {
        return expiresin;
    }

    public void setExpiresin(Long expiresin) {
        this.expiresin = expiresin;
    }

    public Long getExpiresinR1() {
        return expiresinR1;
    }

    public void setExpiresinR1(Long expiresinR1) {
        this.expiresinR1 = expiresinR1;
    }

    public Long getExpiresinR2() {
        return expiresinR2;
    }

    public void setExpiresinR2(Long expiresinR2) {
        this.expiresinR2 = expiresinR2;
    }

    public Long getExpiresinW1() {
        return expiresinW1;
    }

    public void setExpiresinW1(Long expiresinW1) {
        this.expiresinW1 = expiresinW1;
    }

    public Long getExpiresinW2() {
        return expiresinW2;
    }

    public void setExpiresinW2(Long expiresinW2) {
        this.expiresinW2 = expiresinW2;
    }

    public Long getReexpiresin() {
        return reexpiresin;
    }

    public void setReexpiresin(Long reexpiresin) {
        this.reexpiresin = reexpiresin;
    }

    public Long getAuthorizeTime() {
        return authorizeTime;
    }

    public void setAuthorizeTime(Long authorizeTime) {
        this.authorizeTime = authorizeTime;
    }
}
