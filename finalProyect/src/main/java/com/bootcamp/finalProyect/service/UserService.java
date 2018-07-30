package com.bootcamp.finalProyect.service;

import com.bootcamp.finalProyect.model.User;
import com.bootcamp.finalProyect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void createUser(User user){
        userRepository.save(user);
    }

    public void editUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }

    public List<User> findByName(String name){
        List<User> userList = new ArrayList<>();
        userRepository.findByName(name);
        return userList;
    }

    public User findByUsername(String username){
        List<User> userList = userRepository.findByUsername(username);
        if (userList.size() > 0){
            User user = userList.get(0);
            return user;
        }
        else{
            return null;
        }
    }

}
