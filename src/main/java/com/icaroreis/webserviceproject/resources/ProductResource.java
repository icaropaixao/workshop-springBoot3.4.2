package com.icaroreis.webserviceproject.resources;


// classe Resouce
/* responsável por lidar com as requisições HTTP (GET, POST, PUT, DELETE)
relacionadas aos usuários. */

import com.icaroreis.webserviceproject.entities.Product;
import com.icaroreis.webserviceproject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/products") // guia no localHost
public class ProductResource {

    @Autowired
    private ProductService productService;

    // Requisições
    @GetMapping
    public ResponseEntity<List<Product>> finAllProducts() {
        List<Product> list = productService.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product obj = productService.findById(id);
        return ResponseEntity.ok().body(obj);
    }


}
