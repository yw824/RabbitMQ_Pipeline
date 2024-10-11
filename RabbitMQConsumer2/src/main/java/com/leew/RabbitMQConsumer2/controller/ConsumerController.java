package com.leew.RabbitMQConsumer2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer2")
public class ConsumerController {
    @GetMapping("/test")
    public String test() {
        return "Consumer2 - page test";
    }
}
