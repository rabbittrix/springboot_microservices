package com.jrsf.myfood.register.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuDto {

    private String name;
    private Double price;
    private Long restaurant;
}
