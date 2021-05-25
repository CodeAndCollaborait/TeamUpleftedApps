package com.spring.tutorial.SpringTutorials;

import com.spring.tutorial.SpringTutorials.annotations.AnnotationApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringTutorialsApplication {
  
  public static void main(String[] args) {
	SpringApplication.run(SpringTutorialsApplication.class, args);
	AnnotationApp.methodCalls();
	
  }
  
  
}
