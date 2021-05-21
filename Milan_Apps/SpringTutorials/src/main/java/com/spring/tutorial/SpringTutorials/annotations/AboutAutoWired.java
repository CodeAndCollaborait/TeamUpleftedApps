package com.spring.tutorial.SpringTutorials.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class AboutAutoWired {
  
  private String className;
  private String ojbName;
  
  
  public AboutAutoWired(String className, String ojbName) {
	this.className = className;
	this.ojbName = ojbName;
  }
  
  public String getClassName() {
	return className;
  }
  
  public void setClassName(String className) {
	this.className = className;
  }
  
  public String getOjbName() {
	return ojbName;
  }
  
  public void setOjbName(String ojbName) {
	this.ojbName = ojbName;
  }
  
  @Override
  public String toString() {
	return "AboutAutoWired{" +
			"className='" + className + '\'' +
			", ojbName='" + ojbName + '\'' +
			'}';
  }
}
