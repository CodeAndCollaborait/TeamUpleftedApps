package com.spring.tutorial.SpringTutorials.annotations;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary            // gives a default
@Component          //create bean
public class AdminUser implements User{

    @Override
    public String getUserInfo(String str) {
        return str;
    }
}
