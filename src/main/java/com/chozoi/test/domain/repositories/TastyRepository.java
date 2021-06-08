package com.chozoi.test.domain.repositories;

import com.chozoi.test.domain.entities.Cart;
import com.chozoi.test.domain.entities.Tasty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TastyRepository extends JpaRepository<Tasty, Integer> {
    List<Tasty> findByName(String name);

    List<Tasty> findAllByCategoryId(int categoryId);
}
