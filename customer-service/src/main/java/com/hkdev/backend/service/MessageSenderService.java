package com.hkdev.backend.service;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class MessageSenderService {

    private static final String CUSTOMER_Q = "CustomerQ";

    @Autowired
    private RabbitMessagingTemplate messagingTemplate;

    @Bean
    private Queue queue() {
        return new Queue(CUSTOMER_Q, false);
    }

    public void send(String email) {
        messagingTemplate.convertAndSend(CUSTOMER_Q, email);
    }
}
