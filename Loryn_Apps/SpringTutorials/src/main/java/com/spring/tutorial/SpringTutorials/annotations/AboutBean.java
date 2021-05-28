package com.spring.tutorial.SpringTutorials.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration // Store and declare spring bean/object
public class AboutBean {
/*
    //default is singleton unless use Scope("design pattern") annotation
    @Bean
    //@Scope("prototype")
    public CustomerService getBeancustomerService(){
        return new CustomerService();
    }

    @Bean("order")
    public OrderService getBeanorderService(){
        return new OrderService();
    }

    @Bean
    public User getUser(User user){
        return user;
    }
    */
}

