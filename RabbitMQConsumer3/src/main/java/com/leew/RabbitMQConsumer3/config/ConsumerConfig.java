package com.leew.RabbitMQConsumer3.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerConfig {

    // value under is in application.yml
    @Value("${rabbitmq.queue.name}")
    private String queue;


    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    @Bean
    public Queue queue() {
        return new Queue(queue);
    }

    // spring bean for rabbitmq exchange
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchange);
    }

    // spring bean for rabbitmq binding
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with(routingKey);
        // with : routingKey 속성값이 들어가야 하고, 이전에 우리가 rabbitmq에서 설정한 routing key를 설정해야 한다.
    }

    @Bean
    // public MessageConverter messageConverter() { ,,, } // return 자료형 틀려서 에러
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        // import org.springframework.amqp.rabbit.connection.ConnectionFactory;
        // 다른 경우가 많다.
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);

        // 메시지 변환기를 설정할 경우
        rabbitTemplate.setMessageConverter(messageConverter());

        return rabbitTemplate;
    }
}
