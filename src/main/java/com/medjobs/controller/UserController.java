package com.medjobs.controller;

import com.medjobs.entity.User;
import com.medjobs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }
    @PostMapping("/login")
    public String loginUser(@RequestBody User user){
        return userService.loginUser(user.getEmail(), user.getPassword());
    }
}
