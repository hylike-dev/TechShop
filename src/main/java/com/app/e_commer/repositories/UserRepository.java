package com.app.e_commer.repositories;

import com.app.e_commer.entities.Cart;
import com.app.e_commer.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public boolean existsByEmail(String email);




}
