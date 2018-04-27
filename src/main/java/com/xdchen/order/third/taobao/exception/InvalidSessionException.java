package com.xdchen.order.third.taobao.exception;

public class InvalidSessionException extends RuntimeException {
    private long userId;

    public InvalidSessionException(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
