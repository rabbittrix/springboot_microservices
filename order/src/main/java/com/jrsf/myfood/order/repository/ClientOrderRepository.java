package com.jrsf.myfood.order.repository;

import ch.qos.logback.core.net.server.Client;
import com.jrsf.myfood.order.entity.ClientOrder;
import com.jrsf.myfood.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientOrderRepository extends JpaRepository<ClientOrder, Long> {

    Optional<Client> findByIdClient(Long aLong);
}
