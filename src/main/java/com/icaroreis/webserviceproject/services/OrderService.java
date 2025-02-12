package com.icaroreis.webserviceproject.services;

import com.icaroreis.webserviceproject.entities.Order;
import com.icaroreis.webserviceproject.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired // Essa anotação indica que o Spring deve injetar o OrderRepository
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    // IMPLEMENTAÇÕES DE OPERAÇÕES
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
    public Order findById(Long id) {
        Optional<Order> obj =  orderRepository.findById(id);
        return obj.get();
    }


}
