package com.jrsf.myfood.register.controller;

import com.jrsf.myfood.register.dto.MenuDto;
import com.jrsf.myfood.register.entity.Menu;
import com.jrsf.myfood.register.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping(value = "/insert", consumes = "application/stream+json")
    public ResponseEntity insertMenu(@RequestBody MenuDto menuDto){
        try {
            Menu menu = menuService.insertMenu(menuDto);
            MenuDto dto = new MenuDto();
            if (menu != null){
                dto.setName(menu.getName());
                dto.setPrice(menu.getPrice());
                dto.setRestaurant(menu.getRestaurant().getId());
            }
            return Objects.nonNull(menu) ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMenu(@PathVariable("id") Long id, @RequestBody MenuDto menuDto){
        Menu menu = Menu.create(menuDto);
        menu.setId(id);
        Menu updatedMenu = menuService.updateMenu(menu);

        return Objects.nonNull(updatedMenu) ? ResponseEntity.ok(updatedMenu) : ResponseEntity.notFound().build();

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMenu(@PathVariable("id") Long id){

        return menuService.deleteMenu(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        Optional<Menu> menu = menuService.findById(id);
        return menu.isPresent() ? ResponseEntity.ok(menu.get()) : ResponseEntity.notFound().build();
    }
}
