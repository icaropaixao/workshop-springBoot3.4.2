package com.icaroreis.webserviceproject.resources;


// classe Resouce
/* responsável por lidar com as requisições HTTP (GET, POST, PUT, DELETE)
relacionadas aos usuários. */

import com.icaroreis.webserviceproject.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/Users") // guia no localHost
public class UserResource {


    // exemplo de requisição
    @GetMapping
    public ResponseEntity<User> finAllUsers() {
        User user = new User(1L,"Mari","mari@","12223","55588","Flamengo");

        if (user.getTime() == "Flamengo"){
            user.setTime("Flamengo é o melhor!");
            return ResponseEntity.ok().body(user);
        }
        return ResponseEntity.ok().body(user);
    }

}
