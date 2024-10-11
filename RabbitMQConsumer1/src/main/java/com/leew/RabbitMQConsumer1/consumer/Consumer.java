package com.leew.RabbitMQConsumer1.consumer;

import com.leew.RabbitMQConsumer1.dto.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void receiveMessage(User user) {
        System.out.println("Consumer Group 1 received: " + user);
    }
}
