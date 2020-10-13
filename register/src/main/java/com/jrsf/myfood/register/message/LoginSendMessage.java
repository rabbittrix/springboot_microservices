package com.jrsf.myfood.register.message;

import com.jrsf.myfood.register.dto.ClientOrderDto;
import com.jrsf.myfood.register.dto.LoginDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LoginSendMessage {

    @Value("${register.rabbitmq.exchange}")
    private String exchange;

    @Value("${register.login.rabbitmq.routingkey}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public LoginSendMessage(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(LoginDto loginDto){
        rabbitTemplate.convertAndSend(exchange, routingKey, loginDto);
    }
}
