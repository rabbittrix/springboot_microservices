package com.jrsf.myfood.register.controller;

import com.jrsf.myfood.register.dto.ClientDto;
import com.jrsf.myfood.register.dto.RestaurantDto;
import com.jrsf.myfood.register.entity.Client;
import com.jrsf.myfood.register.entity.Restaurant;
import com.jrsf.myfood.register.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/insert")
    public ResponseEntity insertRestaurant(@RequestBody RestaurantDto restaurantDto){
        try {
            return ResponseEntity.ok(restaurantService.insertRestaurant(Restaurant.create(restaurantDto)));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateRestaurant(@PathVariable("id") Long id, @RequestBody RestaurantDto restaurantDto){
        Restaurant restaurant = Restaurant.create(restaurantDto);
        restaurant.setId(id);
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(restaurant);

        return Objects.nonNull(updatedRestaurant) ? ResponseEntity.ok(updatedRestaurant) : ResponseEntity.notFound().build();

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteRestaurant(@PathVariable("id") Long id){

        return restaurantService.deleteRestaurant(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        Optional<Restaurant> restaurant = restaurantService.findById(id);
        return restaurant.isPresent() ? ResponseEntity.ok(restaurant.get()) : ResponseEntity.notFound().build();
    }
}
