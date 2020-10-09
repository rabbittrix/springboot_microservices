package com.jrsf.myfood.register.dto;

import com.jrsf.myfood.register.entity.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuDto {

    private String name;
    private Double price;
    private Long idRestaurant;

    public static MenuDto create(Menu menu) {
        return new ModelMapper().map(menu, MenuDto.class);
    }
}
