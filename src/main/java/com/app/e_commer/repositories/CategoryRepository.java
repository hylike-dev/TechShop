package com.app.e_commer.repositories;

import com.app.e_commer.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Cart, Long> {
}
