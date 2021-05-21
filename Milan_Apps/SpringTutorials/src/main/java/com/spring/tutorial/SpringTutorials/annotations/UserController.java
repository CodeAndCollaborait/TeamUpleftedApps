package com.spring.tutorial.SpringTutorials.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
