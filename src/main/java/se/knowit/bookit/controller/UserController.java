package se.knowit.bookit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.knowit.bookit.model.User;
import se.knowit.bookit.repository.UserRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserRepository repository;

    @Autowired
    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) repository.findAll();
    }

    @PostMapping("/users")
    void addUser(@RequestBody User user) {
        repository.save(user);
    }
}
