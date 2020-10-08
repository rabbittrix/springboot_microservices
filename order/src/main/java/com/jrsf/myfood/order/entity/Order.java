package com.jrsf.myfood.order.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idClient;
    private Long idRestaurant;
    private Long idMenu;
}
