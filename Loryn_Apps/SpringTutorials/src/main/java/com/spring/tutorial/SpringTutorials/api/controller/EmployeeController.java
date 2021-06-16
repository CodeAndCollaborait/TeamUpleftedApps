package com.spring.tutorial.SpringTutorials.api.controller;

import com.spring.tutorial.SpringTutorials.api.database.EmpDatabase;
import com.spring.tutorial.SpringTutorials.api.model.Employee;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController()
@RequestMapping("/api")
public class EmployeeController {

    //dependency injection
    @Autowired
    private EmpDatabase empDatabase;

    @GetMapping("/emplist")
    public List<Employee> getListOfEmployee(){
        return empDatabase.findAll();
    }

    @GetMapping("/emplist/{id}")
    public Optional <Employee> getEmpById
            (@PathVariable(value = "id") long id){
        return empDatabase.findById(id);
    }

    //Only when creating a new record
    @PostMapping("/emplist")
    //@RequestBody- allows you to insert employee into data.sql
    public Employee createNewEmployee(@RequestBody Employee employee){
        return empDatabase.save(employee);


    }

    @PutMapping("/emplist/{id}")
    public Employee updateExistingEmp(@RequestBody Employee employee, @PathVariable(value = "id") long id) throws Exception{
        //combination of read and update

        //Read
        Employee employeeDetails = empDatabase.findById(id).orElseThrow(()->new Exception("Emp by this ID" + id + "not found in database"));

        employeeDetails.setEmpName(employee.getEmpName());
        employeeDetails.setEmpDept(employee.getEmpDept());
        employeeDetails.setEmpIncome(employee.getEmpIncome());
        employeeDetails.setActive(employee.getActive());

        empDatabase.save(employeeDetails);
        return employeeDetails;

    }
    @DeleteMapping("/emplist/{id}")
    public Map<Long,String> removeEmpFromList(@PathVariable(value = "id") long id) throws Exception{
        Employee employeeDetails = empDatabase.findById(id).orElseThrow(()->new Exception("Emp by this ID" + id + "not found in database"));

        empDatabase.delete(employeeDetails);
        Map<Long,String> empDelete =new HashMap<>();
        empDelete.put(id, "Emp by this ID has been deleted");
        return empDelete;

    }
}
