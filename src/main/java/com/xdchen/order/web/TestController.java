package com.xdchen.order.web;

import com.xdchen.order.config.TaobaoConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private TaobaoConfig taobaoConfig;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
