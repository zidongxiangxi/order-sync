package com.xdchen.order.timer;

import com.xdchen.order.listener.StartListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedule {
    private final StartListener startListener;

    @Autowired
    public Schedule(StartListener startListener) {
        this.startListener = startListener;
    }

    @Scheduled(cron = "0 0/30 * * * *")
    public void scheduled() {

    }

    @Scheduled(cron = "0 0/5 * * * *")
    //5分钟检查一次，看线程是否还存活，挂掉的话，重新启动一个工作线程
    public void checkSyncThread() {
        startListener.startSyncThread();
    }
}
