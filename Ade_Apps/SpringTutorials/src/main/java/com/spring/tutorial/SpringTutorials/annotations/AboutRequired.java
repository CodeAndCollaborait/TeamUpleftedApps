package com.spring.tutorial.SpringTutorials.annotations;


public class AboutRequired {
  
  private double price;
  private double tax;
  private String productName;
  
  
  public double getPrice() {
    return price;
  }
  
  public void setPrice(double price) {
    this.price = price;
  }

  public double getTax() {
    return tax;
  }

  public void setTax(double tax) {
    this.tax = tax;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }
  
  @Override
  public String toString() {
    return "AboutRequired{" +
            "price=" + price +
            ", tax=" + tax +
            ", productName='" + productName + '\'' +
            '}';
  }
}


