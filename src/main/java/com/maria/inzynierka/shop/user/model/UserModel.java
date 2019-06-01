package com.maria.inzynierka.shop.user.model;

import com.maria.inzynierka.shop.user.entities.User;
import com.maria.inzynierka.shop.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserModel {

    @Autowired
    UserRepository userRepository;

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public void addUser(User User) {
        userRepository.save(User);
    }

    public void removeUserById(Long id) {
        userRepository.deleteById(id);
    }
}
