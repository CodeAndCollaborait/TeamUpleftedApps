package com.spring.tutorial.SpringTutorials.api.controller;

import com.spring.tutorial.SpringTutorials.api.database.EmpDatabase;
import com.spring.tutorial.SpringTutorials.api.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmpDatabase empDatabase;

    @GetMapping("/emplist")
    public List<Employee> getListOfEmployee(){
        return empDatabase.findAll();
    }

    @GetMapping("emplist/{id}")
    public Optional<Employee> getEmpById
            (@PathVariable(value = "id") long id){
        return empDatabase.findById(id);
    }



}
