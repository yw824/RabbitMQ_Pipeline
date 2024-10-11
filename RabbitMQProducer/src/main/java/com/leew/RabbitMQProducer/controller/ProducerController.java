package com.leew.RabbitMQProducer.controller;

import com.leew.RabbitMQProducer.dto.User;
import com.leew.RabbitMQProducer.publisher.Producer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    private final Producer producer;

    public ProducerController(Producer producer) {
        this.producer = producer;
    }

    @GetMapping("/test")
    public String test() {
        return "producer - test page";
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestBody User user) {
        System.out.println(user);
        producer.sendMessage(user);
        return ResponseEntity.ok("Send User Data to Group Consumer...");
    }
}
