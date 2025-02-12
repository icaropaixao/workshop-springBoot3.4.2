package com.icaroreis.webserviceproject.repositories;

import com.icaroreis.webserviceproject.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {


}
