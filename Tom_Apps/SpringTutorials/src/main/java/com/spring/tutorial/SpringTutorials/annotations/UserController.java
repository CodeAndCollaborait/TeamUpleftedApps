package com.spring.tutorial.SpringTutorials.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    @Qualifier("adminUser")
    private User user;

    public UserController(User user) {
        this.user = user;
    }

    @GetMapping("/")
    public String getUser(){
        return user.getUserInfo("Admin User One");

    }
}