package com.maria.inzynierka.shop.user.controller;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.maria.inzynierka.shop.user.entities.User;
import com.maria.inzynierka.shop.user.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;

@RestController
public class UserController implements RequestHandler<User, List<User>> {


    @Autowired
    UserModel userModel;

    @GetMapping(value = "/users")
    @PermitAll
    public Iterable<User> getAllUsers() {
        return userModel.getAllUsers();
    }

    @PostMapping(value = "/users")
    @Secured("ROLE_ADMIN")
    public void addUser(@RequestBody User user) {
        userModel.addUser(user);
    }


    @GetMapping(value = "/users/{id}")
    @PermitAll
    public User getUser(@PathVariable("id") Long id) {
        return userModel.getUserById(id);
    }

    @DeleteMapping(value = "/users/{id}")
    @Secured("ROLE_ADMIN")
    public void removeUser(@PathVariable("id") Long id) {
        userModel.removeUserById(id);
    }


    @Override
    public List<User> handleRequest(User user, Context context) {
        return null;
    }
}
