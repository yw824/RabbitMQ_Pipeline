package com.leew.RabbitMQConsumer1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer1")
public class ConsumerController {
    @GetMapping("/test")
    public String test() {
        return "Consumer1 - page test";
    }
}
