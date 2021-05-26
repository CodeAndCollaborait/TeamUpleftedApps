package com.spring.tutorial.SpringTutorials.api.controller;

import com.spring.tutorial.SpringTutorials.api.database.EmpDatabase;
import com.spring.tutorial.SpringTutorials.api.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    //only when we create new record
    @PostMapping("/emplist")
    public Employee createNewEmployee(@RequestBody Employee employee){
        return empDatabase.save(employee);
    }

    @PutMapping("emplist/{id}")
    public Employee updateExistingEmp(@RequestBody Employee employee, @PathVariable(value = "id")long id) throws Exception{

        //Read and Update
        Employee empDetails = empDatabase.findById(id).orElseThrow(()-> new Exception("Emp by this ID" + id + " not found in database"));

        //Update
        empDetails.setEmpName(employee.getEmpName());
        empDetails.setEmpDepartment(employee.getEmpDepartment());
        empDetails.setEmpIncome(employee.getEmpIncome());
        empDetails.setActive(employee.getActive());

        empDatabase.save(empDetails);
        return empDetails;
    }

    @DeleteMapping("emplist/{id}")
    public Map<Long, String> removeEmpFromList( @PathVariable(value = "id")long id) throws Exception{
        Employee empDetails = empDatabase.findById(id).orElseThrow(()-> new Exception("Emp by this ID" + id + " not found in database"));
        empDatabase.delete(empDetails);
        Map<Long, String> empDeleteResponse = new HashMap<>();
        empDeleteResponse.put(id, "Emp by this ID has been deleted");
        return empDeleteResponse;
    }

}
