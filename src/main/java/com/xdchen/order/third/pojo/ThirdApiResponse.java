package com.xdchen.order.third.pojo;

public class ThirdApiResponse {
    public ThirdApiResponse(EServiceResponseCode code) {
        result = "200".equals(code.toString());
        setStatus(code.toString());
        setMessage(code.toZhName());
    }

    public void valueOf(EServiceResponseCode code) {
        result = "200".equals(code.toString());
        setStatus(code.toString());
        setMessage(code.toZhName());
    }
    /**
     * 状态
     */
    private boolean result;

    /**
     * 消息
     */
    private String message;

    /**
     * 对应的编号
     */
    private String status;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
