package com.jrsf.myfood.register.dto;

import com.jrsf.myfood.register.entity.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuOrderDto {
    private Long idMenu;
//    private String name;
//    private Double price;
    private Long idRestaurant;

//    public static MenuOrderDto create(Menu menu) {
//        return new ModelMapper().map(menu, MenuOrderDto.class);
//    }
}
