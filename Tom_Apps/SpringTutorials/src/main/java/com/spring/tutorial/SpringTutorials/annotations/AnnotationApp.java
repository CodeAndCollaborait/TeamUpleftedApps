package com.spring.tutorial.SpringTutorials.annotations;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationApp {
    public static void methodCalls(){
        //creates a container (access to the beans)
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AboutBean.class);

        CustomerService serviceOne = context.getBean(CustomerService.class);
        serviceOne.getCustomerService();
        System.out.println(serviceOne.hashCode());
        CustomerService serviceTwo = context.getBean(CustomerService.class);
        serviceTwo.getCustomerService();
        System.out.println(serviceTwo.hashCode());

        OrderService orderServiceOne = (OrderService) context.getBean("order");
        orderServiceOne.placeOrderService();
        System.out.println(orderServiceOne.hashCode());
        OrderService orderServiceTwo = (OrderService) context.getBean("orderManagement");
        orderServiceTwo.placeOrderService();
        System.out.println(orderServiceTwo.hashCode());
        OrderService orderServiceThree = (OrderService) context.getBean("getOrder");
        orderServiceThree.placeOrderService();
        System.out.println(orderServiceThree.hashCode());
    }
}
