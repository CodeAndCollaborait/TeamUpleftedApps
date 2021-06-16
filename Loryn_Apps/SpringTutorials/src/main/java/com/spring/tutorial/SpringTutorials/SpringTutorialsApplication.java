package com.spring.tutorial.SpringTutorials;

import com.spring.tutorial.SpringTutorials.annotations.*;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//IOC- inversion of control - give control to machine instead of coder
//gives method right below the main method
//spring defautls to singleton
@SpringBootApplication
public class SpringTutorialsApplication {
	//Bean = object
	public static void main(String[] args) {
		SpringApplication.run(SpringTutorialsApplication.class, args);
		//AnnotationApp.methodCalls();


	}
}
//dependency injection -