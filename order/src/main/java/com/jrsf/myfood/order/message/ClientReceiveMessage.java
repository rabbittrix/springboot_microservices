package com.jrsf.myfood.order.message;

import com.jrsf.myfood.order.dto.ClientOrderDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ClientReceiveMessage {

    @RabbitListener(queues = {"${register.client.rabbitmq.queue}"})
    public void receiveMessage(@Payload ClientOrderDto clientOrderDto){
        System.out.println(clientOrderDto);
    }

}
