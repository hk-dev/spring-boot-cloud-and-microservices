package com.hkdev.backend.service;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class MessageReceiverService {

    private static final String CUSTOMER_Q = "CustomerQ";

    @Autowired
    private EmailService emailService;

    @Bean
    public Queue queue() {
        return new Queue(CUSTOMER_Q, false);
    }

    @RabbitListener(queues = CUSTOMER_Q)
    public void process(String email) {
        emailService.sendEmail(email);
    }
}
