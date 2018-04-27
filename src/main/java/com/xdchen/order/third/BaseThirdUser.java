package com.xdchen.order.third;

import java.util.Date;

public class BaseThirdUser {
    private Date lastUpdateTime = null;

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
