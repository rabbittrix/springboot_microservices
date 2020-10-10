package com.jrsf.myfood.order.message;

import com.jrsf.myfood.order.dto.ClientOrderDto;
import com.jrsf.myfood.order.entity.ClientOrder;
import com.jrsf.myfood.order.repository.ClientOrderRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ClientReceiveMessage {
    private final ClientOrderRepository clientOrderRepository;

    @Autowired
    public ClientReceiveMessage(ClientOrderRepository clientOrderRepository) {
        this.clientOrderRepository = clientOrderRepository;
    }

    @RabbitListener(queues = {"${register.client.rabbitmq.queue}"})
    public void receiveMessage(@Payload ClientOrderDto clientOrderDto){
        System.out.println(clientOrderDto);
        clientOrderRepository.save(ClientOrder.create(clientOrderDto));
    }

}
