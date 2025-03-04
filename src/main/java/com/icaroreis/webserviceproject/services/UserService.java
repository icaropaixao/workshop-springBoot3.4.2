package com.icaroreis.webserviceproject.services;

import com.icaroreis.webserviceproject.entities.User;
import com.icaroreis.webserviceproject.repositories.UserRepository;
import com.icaroreis.webserviceproject.services.exceptions.DatabaseException;
import com.icaroreis.webserviceproject.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;

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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id)); // metodo (orElseThrow) tenta dar um Get e se estiver Null lança a exception programada
    }

    // metodo para inserir um User
    public User insert (User obj) {
        return userRepository.save(obj);
    }

    // metodo para deletar um user
    public void delete (Long id) {

         try {
             userRepository.deleteById(id);
            // caso de uma excpetion do tipo EmpryResult, lança uma ResourceNotFoundException
         } catch (EmptyResultDataAccessException e) {
                 throw new ResourceNotFoundException(id);

         }
         catch (DataIntegrityViolationException e){
             throw new DatabaseException(e.getMessage());
         }

    }

    // metodo para atualizar um user
    public User update (Long id, User obj){

        try{
            User entity = userRepository.getReferenceById(id);
            updateData(entity, obj);

            return userRepository.save(entity);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }



    }

    private void updateData(User entity, User obj) {

        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
        entity.setTime(obj.getTime());

    }


}
