package com.jrsf.myfood.register.message;

import com.jrsf.myfood.register.dto.ClientOrderDto;
import com.jrsf.myfood.register.dto.MenuOrderDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MenuSendMessage {

    @Value("${register.rabbitmq.exchange}")
    private String exchange;

    @Value("${register.menu.rabbitmq.routingkey}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public MenuSendMessage(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(MenuOrderDto menuOrderDto){
        rabbitTemplate.convertAndSend(exchange, routingKey, menuOrderDto);
    }
}
