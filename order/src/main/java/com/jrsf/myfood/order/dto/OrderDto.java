package com.jrsf.myfood.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long idClient;
    private Long idRestaurant;
    private Long idMenu;
}
