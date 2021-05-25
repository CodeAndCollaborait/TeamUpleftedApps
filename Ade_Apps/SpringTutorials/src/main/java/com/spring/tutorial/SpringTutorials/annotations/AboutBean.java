package com.spring.tutorial.SpringTutorials.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration  //Store and declare spring bean/object
public class AboutBean {
  
  @Bean
  @Scope("singleton")
  public CustomerService getBeanCustomerService() {
	return new CustomerService();
  }
  
  @Bean(name = {"order", "orderManagement"})
  public OrderService getBeanOrderService() {
	return new OrderService();
  }
  
  @Bean(name = "getOrder")
  public OrderService getOrder() {
	return new OrderService();
  }
  
  
}


