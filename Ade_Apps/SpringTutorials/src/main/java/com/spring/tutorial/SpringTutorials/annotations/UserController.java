package com.spring.tutorial.SpringTutorials.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
public class UserController {
  
  @Autowired
  @Qualifier("adminUser")
  User user;
  
  
  public UserController(User user) {
	this.user = user;
  }
  
  
  @GetMapping("/hello")
  public String getUser() {
	return user.getUserInfo("User One");
  }
  
  
}
