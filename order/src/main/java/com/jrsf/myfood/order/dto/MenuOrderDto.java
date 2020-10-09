package com.jrsf.myfood.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuOrderDto {
    private Long idMenu;
    private Long idRestaurant;
}
