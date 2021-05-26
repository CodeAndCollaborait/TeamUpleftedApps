package com.spring.tutorial.SpringTutorials.api.controller;

import com.spring.tutorial.SpringTutorials.api.database.EmployeeDatabase;
import com.spring.tutorial.SpringTutorials.api.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeDatabase employeeDatabase;

    // read a data -- @GetMapping
    @GetMapping("/emplist")
    public List<Employee> getListOfEmployee(){
        return employeeDatabase.findAll();
    }

    @GetMapping("/emplist/{id}")
    public Optional<Employee> getEmpById(@PathVariable(value = "id") long id){
        return employeeDatabase.findById(id);
    }

    // post a data @PostMapping --- when we create a new record
    //@RequestBody allows to insert an Empoloyee object
    @PostMapping("/emplist")
    public Employee createNewEmployee(@RequestBody Employee employee){
        return employeeDatabase.save(employee);
    }

    // update information
    //@PutMapping is a combination of get and post method
//    @PutMapping("/emplist")
//    public Employee updateEmployee(@RequestBody Employee employee){
//        return employeeDatabase.save(employee);
//    }

    @PutMapping("/emplist/{id}")
    public Employee updateExistingEmployee(@RequestBody Employee employee, @PathVariable(value = "id") long id) throws Exception {
        Employee updateEmployee = employeeDatabase.findById(id).orElseThrow(() -> new Exception("Emp by this ID " + id + " not found in database"));

        updateEmployee.setEmpName(employee.getEmpName());
        updateEmployee.setEmpDepartment(employee.getEmpDepartment());
        updateEmployee.setEmpIncome(employee.getEmpIncome());
        updateEmployee.setActive(employee.getActive());

        employeeDatabase.save(updateEmployee);
        return updateEmployee;
        //return employeeDatabase.save(employee);
    }


    // delete @DeleteMapping
    @DeleteMapping("emplist/{id}")
    public Map<Long, String> deleteEmployeeFromList(@PathVariable(value = "id") long id) throws Exception{
        Employee deleteEmployee = employeeDatabase.findById(id).orElseThrow(() -> new Exception("Emp by this ID " + id + " not found in database"));
        employeeDatabase.delete(deleteEmployee);
        Map<Long, String> deleteEmpResponse = new HashMap<>();
        deleteEmpResponse.put(id, "Emp by this ID has been deleted ");
        return deleteEmpResponse;
    }


}
