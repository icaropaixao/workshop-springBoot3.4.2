package com.icaroreis.webserviceproject.services;

import com.icaroreis.webserviceproject.entities.Product;
import com.icaroreis.webserviceproject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired // Essa anotação indica que o Spring deve injetar o ProductRepository
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj =  productRepository.findById(id);
        return obj.get();
    }


}
