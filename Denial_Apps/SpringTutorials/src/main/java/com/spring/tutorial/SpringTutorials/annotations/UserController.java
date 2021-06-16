package com.spring.tutorial.SpringTutorials.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    @Qualifier("adminUserTwo")              //
    private User user;

    public UserController(User user){
        this.user = user;
    }

    @GetMapping("/")
    public String getUser(){
        return user.getUserInfo("Admin user one " + "Admin user two" );
    }
    @GetMapping("/hello")
    public String getUserTwo(){
        return user.getUserInfo("Admin user two");
    }

//    @GetMapping("/hello/hi")
//    public String getUserThree(){
//        return user.getUserInfo("Admin user three");
//    }
}
