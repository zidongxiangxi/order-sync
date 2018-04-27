package com.xdchen.order.third;

public class ThirdApiException extends RuntimeException {
    private String message;

    public ThirdApiException() {}

    public ThirdApiException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
