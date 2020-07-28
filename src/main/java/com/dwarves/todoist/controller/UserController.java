package com.dwarves.todoist.controller;

import com.dwarves.todoist.model.User;
import com.dwarves.todoist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/user")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping(path = {"/add"})
    public int addUser(@NonNull @RequestBody User user) {
        return userService.addUser(user);
    }
}
