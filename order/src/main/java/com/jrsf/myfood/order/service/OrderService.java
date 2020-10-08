package com.jrsf.myfood.order.service;

import com.jrsf.myfood.order.entity.Order;
import com.jrsf.myfood.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order insertOrder(Order order){
        return orderRepository.save(order);
    }
}
