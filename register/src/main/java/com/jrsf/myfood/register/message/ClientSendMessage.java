package com.jrsf.myfood.register.message;

import com.jrsf.myfood.register.dto.ClientOrderDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ClientSendMessage {

    @Value("${register.rabbitmq.exchange}")
    private String exchange;

    @Value("${register.client.rabbitmq.routingkey}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ClientSendMessage(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(ClientOrderDto clientOrderDto){
        rabbitTemplate.convertAndSend(exchange, routingKey, clientOrderDto);
    }
}
