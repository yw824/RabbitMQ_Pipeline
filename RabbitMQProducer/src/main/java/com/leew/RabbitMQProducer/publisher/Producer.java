package com.leew.RabbitMQProducer.publisher;

import com.leew.RabbitMQProducer.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    // Autowired는 Service라 자동으로 됨
    private RabbitTemplate rabbitTemplate;

    // 이 클래스에 대한 모든 행동에 대한 Logger를 생성
    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    // Constructor
    public Producer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    // Publish Method
    public void sendMessage(User user) {
        LOGGER.info(String.format("Message sent -> %s", user)); // Data Annotation으로 toString 생성됨
        rabbitTemplate.convertAndSend(exchange, routingKey, user);
    }
}
