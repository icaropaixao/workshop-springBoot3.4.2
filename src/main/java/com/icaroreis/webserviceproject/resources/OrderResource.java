package com.icaroreis.webserviceproject.resources;


// classe Resouce
/* responsável por lidar com as requisições HTTP (GET, POST, PUT, DELETE)
relacionadas aos usuários. */

import com.icaroreis.webserviceproject.entities.Order;
import com.icaroreis.webserviceproject.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/orders") // guia no localHost
public class OrderResource {

    @Autowired
    private OrderService orderService;

    // Requisições
    @GetMapping
    public ResponseEntity<List<Order>> finAllOrders() {
        List<Order> list = orderService.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order obj = orderService.findById(id);
        return ResponseEntity.ok().body(obj);
    }


}
