package com.icaroreis.webserviceproject.services;

import com.icaroreis.webserviceproject.entities.User;
import com.icaroreis.webserviceproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private UserRepository userRepository;

    @Autowired // Essa anotação indica que o Spring deve injetar o UserRepository
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // IMPLEMENTAÇÕES DE OPERAÇÕES
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj =  userRepository.findById(id);
        return obj.get();
    }

    // metodo para inserir um User
    public User insert (User obj) {
        return userRepository.save(obj);
    }


}
