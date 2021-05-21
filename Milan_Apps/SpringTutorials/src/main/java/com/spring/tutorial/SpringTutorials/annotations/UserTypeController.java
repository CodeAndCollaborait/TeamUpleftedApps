package com.spring.tutorial.SpringTutorials.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserTypeController {
  
  @Autowired
  User user;
  
  public UserTypeController(User user) {
	this.user = user;
  }
  
  @GetMapping("/users")
  public String getUser() {
	return user.getUserInfo("User Two from another controller");
  }
}
