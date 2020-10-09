package com.jrsf.myfood.order.message;

import com.jrsf.myfood.order.dto.MenuOrderDto;
import com.jrsf.myfood.order.entity.MenuOrder;
import com.jrsf.myfood.order.repository.MenuOrderRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MenuReceiveMessage {
    private final MenuOrderRepository menuOrderRepository;

    @Autowired
    public MenuReceiveMessage(MenuOrderRepository menuOrderRepository) {
        this.menuOrderRepository = menuOrderRepository;
    }

    @RabbitListener(queues = {"${register.menu.rabbitmq.queue}"})
    public void receiveMessage(@Payload MenuOrderDto menuOrderDto){

        System.out.println(menuOrderDto);
        menuOrderRepository.save(new MenuOrder(null, menuOrderDto.getIdMenu(), menuOrderDto.getIdRestaurant()));
    }

}
