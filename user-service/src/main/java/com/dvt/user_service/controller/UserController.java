package com.dvt.user_service.controller;

import lombok.RequiredArgsConstructor;
import com.dvt.user_service.model.User;
import org.springframework.web.bind.annotation.*;
import com.dvt.user_service.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) {
        return userRepository.findById(id).stream().findFirst().orElse(null);
    }
}
