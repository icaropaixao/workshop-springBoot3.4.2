package com.icaroreis.webserviceproject.resources;


// classe Resouce
/* responsável por lidar com as requisições HTTP (GET, POST, PUT, DELETE)
relacionadas aos usuários. */

import com.icaroreis.webserviceproject.entities.User;
import com.icaroreis.webserviceproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/users") // guia no localHost
public class UserResource {

    @Autowired
    private UserService userService;

    // Requisições
    @GetMapping
    public ResponseEntity<List<User>> finAllUsers() {
        List<User> list = userService.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(obj);
    }


}
