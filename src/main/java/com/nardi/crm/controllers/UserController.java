package com.nardi.crm.controllers;

import com.nardi.crm.entities.User;
import com.nardi.crm.repository.UserRepository;
import com.nardi.crm.services.ProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private static final String USER_CREATED_TOPIC = "USER_CREATED";
    private static final String USER_DELETED_TOPIC = "USER_DELETED";
    private static final String USER_UPDATED_TOPIC = "USER_UPDATED";
    private final UserRepository userRepository;
    private final ProducerService producerService;

    public UserController(UserRepository userRepository, ProducerService producerService) {
        this.userRepository = userRepository;
        this.producerService = producerService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        User saved = userRepository.save(user);
        this.producerService.send(USER_CREATED_TOPIC, saved.getTopicKey(), saved);
        return saved;
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userUpdate) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User updatedUser = user.get();
            updatedUser.setUsername(userUpdate.getUsername());
            updatedUser.setPassword(userUpdate.getPassword());
            return ResponseEntity.ok(userRepository.save(updatedUser));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}