package com.spring.tutorial.SpringTutorials.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserTypeController {
  
  @Autowired
  User user;
  
  
  
  public UserTypeController(User user) {
	this.user = user;
  }
  
  @GetMapping("/users")
  public List<String> getUser() {
    List<String> userList = new ArrayList<>();
    userList.add(user.getUserInfo("Admin users"));
    userList.add(user.getUserInfo("ReadWriter"));
    userList.add(new UserController(user).getUser());
    return userList;
  }
}
