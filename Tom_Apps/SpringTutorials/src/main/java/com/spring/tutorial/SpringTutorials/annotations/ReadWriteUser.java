package com.spring.tutorial.SpringTutorials.annotations;

public class ReadWriteUser implements User {
    @Override
    public String getUserInfo(String userType) {
        return userType;
    }
}
