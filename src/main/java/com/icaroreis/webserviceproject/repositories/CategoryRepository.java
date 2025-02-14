package com.icaroreis.webserviceproject.repositories;

import com.icaroreis.webserviceproject.entities.Category;
import com.icaroreis.webserviceproject.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {


}
