package com.fabricio.rabbitmq.connections;

import com.fabricio.rabbitmq.Util.Rabbitmq;
import com.fabricio.rabbitmq.dto.UserDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumeMessageFromQueueRabbitmq {

    @RabbitListener(queues = Rabbitmq.QUEUE1)
    public void consumeMessageFromQueue(UserDto userDto){
        System.out.println("Message received QUEUE1, message : " + userDto.toString());
    }

    @RabbitListener(queues = Rabbitmq.QUEUE2)
    public void consumeMessageFromQueue2(UserDto userDto){
        System.out.println("Message received QUEUE2, message : " + userDto.toString());
    }
}
