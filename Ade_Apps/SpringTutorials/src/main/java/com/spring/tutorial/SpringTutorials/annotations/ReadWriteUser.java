package com.spring.tutorial.SpringTutorials.annotations;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Primary
@Component
public class ReadWriteUser implements User {
  @Override
  public String getUserInfo(String userType) {
	return "ReadWrite " + userType;
  }
}
