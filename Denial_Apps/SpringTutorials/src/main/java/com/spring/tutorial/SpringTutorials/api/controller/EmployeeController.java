package com.spring.tutorial.SpringTutorials.api.controller;

import com.spring.tutorial.SpringTutorials.api.database.EmployeeDatabase;
import com.spring.tutorial.SpringTutorials.api.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeDatabase employeeDatabase;

    @GetMapping("/emplist")
    public List<Employee> getListOfEmployee(){
        return employeeDatabase.findAll();
    }

    @GetMapping("/emplist/{id}")
    public Optional<Employee> getEmpById(@PathVariable(value = "id") long id){
        return employeeDatabase.findById(id);
    }

}
