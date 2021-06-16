package com.spring.tutorial.SpringTutorials.annotations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AboutBean {
    @Bean
    @Scope("singleton")  // singleton, prototype, request, session -(remember previous session), global-session
    public CustomerService customerService(){
        return new CustomerService();
    }
    @Bean(name = {"order","orderManagement"})
    public OrderService orderService(){
        return new OrderService();
    }
}

