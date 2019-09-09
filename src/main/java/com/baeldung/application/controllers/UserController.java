package com.baeldung.application.controllers;

import com.baeldung.application.entities.User;
import com.baeldung.application.repositories.UserRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable("userId") Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()) {
            User existingUser = user.get();
            System.out.println(existingUser.getName());
            return existingUser;
        } else {
            return new User();
        }
    }


    @PostMapping("/users")
    void addUser(@RequestBody User user) {
        userRepository.save(user);
        System.out.println("New User saved: " + user.getName());
        userRepository.findAll().forEach(System.out::println);
    }

    @PostMapping("/users/edit")
    void editUser(@RequestBody User user) {
        userRepository.save(user);
        System.out.println("User " + user.getId() + " edited: " + user.getName());
    }
}
