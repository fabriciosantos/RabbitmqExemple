package com.fabricio.rabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void enviaMensage(String queue, Object message){
        System.out.println("Send Message queue: "+ queue + " message: "+ message.toString() );
        this.rabbitTemplate.convertAndSend(queue, message);
    }
}
