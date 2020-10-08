package com.jrsf.myfood.register.service;

import com.jrsf.myfood.register.entity.Restaurant;
import com.jrsf.myfood.register.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant insertRestaurant(Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    }

    public Restaurant updateRestaurant(Restaurant restaurant){
        Optional<Restaurant> newRestaurant = restaurantRepository.findById(restaurant.getId());
        if (newRestaurant.isPresent()){
            return restaurantRepository.save(restaurant);
        }else {
            return null;
        }
    }

    public boolean deleteRestaurant(Long id){
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        if (restaurant.isPresent()){
            restaurantRepository.delete(restaurant.get());
            return true;
        }else {
            return false;
        }
    }

    public Optional<Restaurant> findById(Long id){
        return restaurantRepository.findById(id);
    }
}
