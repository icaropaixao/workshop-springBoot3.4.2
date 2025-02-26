package com.icaroreis.webserviceproject.repositories;

import com.icaroreis.webserviceproject.entities.OrderItem;
import com.icaroreis.webserviceproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {


}
