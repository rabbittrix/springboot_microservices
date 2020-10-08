package com.jrsf.myfood.register.entity;

import com.jrsf.myfood.register.dto.MenuDto;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant restaurant;

    public static Menu create(MenuDto menuDto){
        return new ModelMapper().map(menuDto, Menu.class);
    }
}
