package com.icaroreis.webserviceproject.repositories;

import com.icaroreis.webserviceproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
