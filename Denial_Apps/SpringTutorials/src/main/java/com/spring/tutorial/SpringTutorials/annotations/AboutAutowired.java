package com.spring.tutorial.SpringTutorials.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class AboutAutowired {

    private String className;
    private String objectName;

    public AboutAutowired(String className, String objectName) {
        this.className = className;
        this.objectName = objectName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    @Override
    public String toString() {
        return "AboutAutowired{" +
                "className='" + className + '\'' +
                ", objectName='" + objectName + '\'' +
                '}';
    }
}
