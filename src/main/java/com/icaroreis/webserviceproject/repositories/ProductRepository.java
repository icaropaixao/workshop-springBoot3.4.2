package com.icaroreis.webserviceproject.repositories;

import com.icaroreis.webserviceproject.entities.Category;
import com.icaroreis.webserviceproject.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {



}
