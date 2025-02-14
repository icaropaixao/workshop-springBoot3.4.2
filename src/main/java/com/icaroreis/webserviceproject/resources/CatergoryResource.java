package com.icaroreis.webserviceproject.resources;

import com.icaroreis.webserviceproject.entities.Category;
import com.icaroreis.webserviceproject.entities.Category;
import com.icaroreis.webserviceproject.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/category")
public class CatergoryResource {

    @Autowired
    private CategoryService categoryService;

    // Requisições
    @GetMapping
    public ResponseEntity<List<Category>> finAllCategorys() {
        List<Category> list = categoryService.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category obj = categoryService.findById(id);
        return ResponseEntity.ok().body(obj);
    }


}
