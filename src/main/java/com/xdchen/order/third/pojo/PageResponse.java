package com.xdchen.order.third.pojo;

import java.util.List;

public class PageResponse<T> extends ThirdApiResponse {
    private long total;
    private List<T> data;

    public PageResponse(EServiceResponseCode code) {
        super(code);
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
