package com.icaroreis.webserviceproject.services;

import com.icaroreis.webserviceproject.entities.Category;
import com.icaroreis.webserviceproject.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired // Essa anotação indica que o Spring deve injetar o CategoryRepository
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> obj =  categoryRepository.findById(id);
        return obj.get();
    }


}
