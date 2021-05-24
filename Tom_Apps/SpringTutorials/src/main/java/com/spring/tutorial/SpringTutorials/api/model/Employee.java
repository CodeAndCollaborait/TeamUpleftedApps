package com.spring.tutorial.SpringTutorials.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    private long id;
    @Column
    private String empName;
    @Column
    private String empDepartment;
    @Column
    private Boolean isActive;
    @Column
    private Double empIncome;

    public Employee() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDepartment() {
        return empDepartment;
    }

    public void setEmpDepartment(String empDepartment) {
        this.empDepartment = empDepartment;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public double getEmpIncome() {
        return empIncome;
    }

    public void setEmpIncome(double empIncome) {
        this.empIncome = empIncome;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", empDepartment='" + empDepartment + '\'' +
                ", isActive=" + isActive +
                ", empIncome=" + empIncome +
                '}';
    }
}
