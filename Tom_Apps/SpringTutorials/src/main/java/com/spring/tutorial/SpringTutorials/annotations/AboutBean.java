package com.spring.tutorial.SpringTutorials.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //store and declare spring bean(object)
public class AboutBean {

    @Bean //default is singleton
    //@Scope("prototype")
    public CustomerService getBeanCustomerService(){
        return new CustomerService();
    }
    @Bean (name = {"order", "orderManagement"})
    public OrderService getBeanOrderService(){
        return new OrderService();
    }
    @Bean(name = "getOrder")
    public OrderService getOrder(){
        return new OrderService();
    }
}

