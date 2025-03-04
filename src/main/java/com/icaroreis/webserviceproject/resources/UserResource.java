package com.icaroreis.webserviceproject.resources;


// classe Resouce
/* responsável por lidar com as requisições HTTP (GET, POST, PUT, DELETE)
relacionadas aos usuários. */

import com.icaroreis.webserviceproject.entities.User;
import com.icaroreis.webserviceproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    // Inserção de usuario no banco de dados
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj){

        obj = userService.insert(obj);


        // Para requisições POST é neccessario passar em formato de URI dessa forma abaixo
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).body(obj);
    }

    // delete de um usuario no banco de dados
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();


    }


}
