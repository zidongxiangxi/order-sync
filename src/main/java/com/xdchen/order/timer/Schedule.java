package com.xdchen.order.timer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedule {
    @Scheduled(cron = "0 0/30 * * * *")
    public void scheduled() {

    }
}
