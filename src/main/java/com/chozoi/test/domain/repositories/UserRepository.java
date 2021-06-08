package com.chozoi.test.domain.repositories;

import com.chozoi.test.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    List<User> findByName(String name);     //mac dinh
}
