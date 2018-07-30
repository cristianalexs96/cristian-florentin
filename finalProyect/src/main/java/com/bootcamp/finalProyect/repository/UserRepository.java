package com.bootcamp.finalProyect.repository;

import com.bootcamp.finalProyect.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public List<User> findByName(String name);

    public List<User> findByUsername(String username);
}
