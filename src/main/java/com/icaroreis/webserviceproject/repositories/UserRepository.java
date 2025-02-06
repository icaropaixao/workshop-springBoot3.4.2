package com.icaroreis.webserviceproject.repositories;

import com.icaroreis.webserviceproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


}
