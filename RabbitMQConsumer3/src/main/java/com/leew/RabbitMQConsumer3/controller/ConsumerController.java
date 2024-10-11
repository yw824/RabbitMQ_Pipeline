package com.leew.RabbitMQConsumer3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer3")
public class ConsumerController {
    @GetMapping("/test")
    public String test() {
        return "Consumer3 - page test";
    }
}
