package com.jrsf.myfood.order.service;

import ch.qos.logback.core.net.server.Client;
import com.jrsf.myfood.order.entity.Order;
import com.jrsf.myfood.order.repository.ClientOrderRepository;
import com.jrsf.myfood.order.repository.MenuOrderRepository;
import com.jrsf.myfood.order.repository.OrderRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ClientOrderRepository clientOrderRepository;
    private final MenuOrderRepository menuOrderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, ClientOrderRepository clientOrderRepository, MenuOrderRepository menuOrderRepository) {
        this.orderRepository = orderRepository;
        this.clientOrderRepository = clientOrderRepository;
        this.menuOrderRepository = menuOrderRepository;
    }

    public Order saveOrder(Order order) throws NotFoundException {

        System.out.println(order);

        final Optional<Client> client = clientOrderRepository.findByIdClient(order.getIdClient());

        if (client.isEmpty()) {
            throw new NotFoundException("Client not found");
        }

        System.out.println(order.getIdMenu());
        System.out.println(order.getIdRestaurant());
        final Optional<Menu> menu = menuOrderRepository.findByIdMenuAndIdRestaurant(order.getIdMenu(), order.getIdRestaurant());

        if (menu.isEmpty()) {
            throw new NotFoundException("Menu or restaurants not found");
        }

        return orderRepository.save(order);
    }
}
