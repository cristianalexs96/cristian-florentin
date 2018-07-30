package com.bootcamp.finalProyect.controller;

import com.bootcamp.finalProyect.model.User;
import com.bootcamp.finalProyect.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(value = "Users microservice", description = "This API has a CRUD for an user")
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("")
    @ApiOperation(value = "Add an user", notes = "Creates an user into the DB" )
    public void addUser(@Valid @RequestBody User user) throws Exception {
        try {
            userService.createUser(user);
        }
        catch (Exception e){
            throw new Exception("Error creating user");
        }
    }

    @GetMapping(value = "", params = "name")
    @ApiOperation(value = "Get users by name", notes = "Returns a list with the founded users" )
    public List<User> getByName(@RequestParam(value="name") String name) throws Exception {
        try {
            return userService.findByName(name);
        }
        catch (Exception e){
            throw new Exception("Error in services");
        }

    }

    @GetMapping(value = "", params = "username")
    @ApiOperation(value = "Get an user by username", notes = "Returns an user" )
    public User getByUsername(@RequestParam(value="username") String username) throws Exception {
        try {
            return userService.findByUsername(username);
        }
        catch (Exception e){
            throw new Exception("Error in services");
        }

    }

}
