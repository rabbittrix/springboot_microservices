package com.jrsf.myfood.order.repository;

import com.jrsf.myfood.order.entity.MenuOrder;
import com.jrsf.myfood.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuOrderRepository extends JpaRepository<MenuOrder, Long> {
}
