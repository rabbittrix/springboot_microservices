package com.jrsf.myfood.register.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {

    private String name;
    private String email;
    private String password;
}
