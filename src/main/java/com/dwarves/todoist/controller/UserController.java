package com.dwarves.todoist.controller;

import com.dwarves.todoist.model.User;
import com.dwarves.todoist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("api/user")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping(path = {"/add"})
    public ResponseEntity<?> addUser(@Valid @NonNull @RequestBody User user) {

        if (userService.addUser(user) == 0) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}
