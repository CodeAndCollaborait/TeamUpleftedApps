package com.spring.tutorial.SpringTutorials.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AnnotationApp {
  
  public static void methodCalls() {
	AnnotationConfigApplicationContext context
			= new AnnotationConfigApplicationContext(AboutBean.class);
	
	CustomerService service = context.getBean(CustomerService.class);
	service.getCustomerService();
	System.out.println(service.hashCode());
	CustomerService serviceTwo = context.getBean(CustomerService.class);
	serviceTwo.getCustomerService();
	System.out.println(serviceTwo.hashCode());
	
	OrderService orderService = (OrderService) context.getBean("order");
	orderService.placeOrderService();
	System.out.println(orderService.hashCode());
	OrderService orderServiceTwo =
			(OrderService) context.getBean("orderManagement");
	orderServiceTwo.placeOrderService();
	System.out.println(orderServiceTwo.hashCode());
	
	OrderService orderServiceThree =
			(OrderService) context.getBean("getOrder");
	orderServiceThree.placeOrderService();
	System.out.println(orderServiceTwo.hashCode());
	
	
  }
}
