package com.chozoi.test.domain.repositories;

import com.chozoi.test.domain.entities.Cart;
import com.chozoi.test.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRespository extends JpaRepository<Cart, Integer> {

}
