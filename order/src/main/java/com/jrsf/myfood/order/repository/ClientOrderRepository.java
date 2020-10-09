package com.jrsf.myfood.order.repository;

import com.jrsf.myfood.order.entity.ClientOrder;
import com.jrsf.myfood.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientOrderRepository extends JpaRepository<ClientOrder, Long> {
}
