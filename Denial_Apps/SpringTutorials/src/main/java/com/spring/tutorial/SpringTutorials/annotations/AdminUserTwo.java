package com.spring.tutorial.SpringTutorials.annotations;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class AdminUserTwo implements User{
    @Override
    public String getUserInfo(String str) {
        return str;
    }
}
