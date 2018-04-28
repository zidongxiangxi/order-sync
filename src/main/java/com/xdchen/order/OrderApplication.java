package com.xdchen.order;

import com.xdchen.order.config.JingdongConfig;
import com.xdchen.order.config.TaobaoConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties({TaobaoConfig.class, JingdongConfig.class})
@MapperScan("com.xdchen.order.dao")
@EnableScheduling
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
