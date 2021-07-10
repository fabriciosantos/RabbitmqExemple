package com.fabricio.rabbitmq.connections;

import com.fabricio.rabbitmq.Util.Rabbitmq;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class SendMessageFromQueueRabbitmq {

     private AmqpAdmin amqpAdmin;

     public SendMessageFromQueueRabbitmq(AmqpAdmin amqpAdmin){
          this.amqpAdmin = amqpAdmin;
     }

     private Queue queue(String queue) {
          return new Queue(queue, true, false, false);
     }

     private DirectExchange exchange(){
          return new DirectExchange(Rabbitmq.EXCHANGE_NAME);
     }

     private Binding binding(Queue queue, DirectExchange exchange) {
          return new Binding(queue.getName(), Binding.DestinationType.QUEUE, exchange.getName(), queue.getName(), null);
     }

     @PostConstruct
     private void add(){
          Queue queue1 = this.queue(Rabbitmq.QUEUE1);
          Queue queue2 = this.queue(Rabbitmq.QUEUE2);

          DirectExchange troca = this.exchange();

          Binding binding1 = this.binding(queue1, troca);

          Binding binding2 = this.binding(queue2, troca);

          this.amqpAdmin.declareQueue(queue1);
          this.amqpAdmin.declareQueue(queue2);

          this.amqpAdmin.declareExchange(troca);

          this.amqpAdmin.declareBinding(binding1);
          this.amqpAdmin.declareBinding(binding2);
     }
}
