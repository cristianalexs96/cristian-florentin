package com.bootcamp.finalProyect.repository;

import com.bootcamp.finalProyect.model.Cart;
import com.bootcamp.finalProyect.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    public List<Cart> findAllByUser(User user);
}
