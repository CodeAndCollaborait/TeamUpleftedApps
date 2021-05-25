package com.spring.tutorial.SpringTutorials;

import com.spring.tutorial.SpringTutorials.annotations.AboutBean;
import com.spring.tutorial.SpringTutorials.annotations.AnnotationApp;
import com.spring.tutorial.SpringTutorials.annotations.CustomerService;
import com.spring.tutorial.SpringTutorials.annotations.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringTutorialsApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringTutorialsApplication.class, args);
		AnnotationApp.methodCalls();
	}
}
