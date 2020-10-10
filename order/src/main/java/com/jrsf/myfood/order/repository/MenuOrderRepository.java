package com.jrsf.myfood.order.repository;

import com.jrsf.myfood.order.entity.MenuOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.Optional;

@Repository
public interface MenuOrderRepository extends CrudRepository<MenuOrder, Long> {
    @Query("SELECT m FROM Menu m WHERE m.idMenu = ?1 AND m.idRestaurant = ?2")
    Optional<Menu> findByIdMenuAndIdRestaurant(Long idMenu, Long idRestaurant);
}
