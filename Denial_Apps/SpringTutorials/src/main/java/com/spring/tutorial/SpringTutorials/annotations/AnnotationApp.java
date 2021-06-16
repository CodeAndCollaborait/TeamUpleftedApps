package com.spring.tutorial.SpringTutorials.annotations;

import com.spring.tutorial.SpringTutorials.SpringTutorialsApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

public class AnnotationApp {

//    @Autowired
//    private static AboutAutowired aboutAutowired;

    public static void methodCalls(){

        //aboutAutowired.setClassName("AnnotationApp");
       // aboutAutowired.setObjectName("aboutAutoMethod");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AboutBean.class);

        CustomerService service = context.getBean(CustomerService.class);
        service.getCustomerService();
        System.out.println(service.hashCode());

        // calling by class name
        OrderService orderService = context.getBean(OrderService.class);
        orderService.placeOrderService();
        System.out.println(orderService.hashCode());


        // calling by name
        OrderService orderService1 = (OrderService) context.getBean("order");
        orderService1.placeOrderService();
        System.out.println(orderService1.hashCode());

        OrderService orderService2 = (OrderService) context.getBean("orderManagement");
        orderService2.placeOrderService();
        System.out.println(orderService2.hashCode());

//        aboutAutowired.getClassName();
//        aboutAutowired.getObjectName();
//        aboutAutowired.toString();
      //  User user = context.getBean(User.class);
    }
}
