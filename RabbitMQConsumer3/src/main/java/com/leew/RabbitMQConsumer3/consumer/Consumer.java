package com.leew.RabbitMQConsumer3.consumer;

import com.leew.RabbitMQConsumer3.dto.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void receiveMessage(User user) {
        System.out.println("Consumer Group 3 received: " + user);
    }
}