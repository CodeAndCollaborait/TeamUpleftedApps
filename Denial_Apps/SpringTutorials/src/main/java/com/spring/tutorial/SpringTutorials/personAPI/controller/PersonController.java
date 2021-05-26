package com.spring.tutorial.SpringTutorials.personAPI.controller;

import com.spring.tutorial.SpringTutorials.api.model.Employee;
import com.spring.tutorial.SpringTutorials.personAPI.database.PersonDatabase;
import com.spring.tutorial.SpringTutorials.personAPI.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/personapi")
public class PersonController {

    @Autowired
    private PersonDatabase personDatabase;

    @GetMapping("/personlist")
    public List<Person> getPersonList(){
        return personDatabase.findAll();
    }

    @GetMapping("/personlist/{id}")
    public Optional<Person> getEmpById(@PathVariable(value = "id") long id){
        return personDatabase.findById(id);
    }

    // add new person record
    @PostMapping("/personlist")
    public Person addNewPerson(@RequestBody Person person){
        return personDatabase.save(person);
    }

    //update existing person record
    @PutMapping("/personlist/{id}")
    public Person updateEmployee(@RequestBody Person person, @PathVariable(value = "id") long id) throws Exception {
        Person updatePerson = personDatabase.findById(id).orElseThrow(() -> new Exception("Person by this SSN  " + id + " not found in database"));
        updatePerson.setAddress(person.getAddress());
        updatePerson.setAge(person.getAge());
        updatePerson.setFirstName(person.getFirstName());
        updatePerson.setLastName(person.getLastName());
        updatePerson.setTitle(person.getTitle());
        return personDatabase.save(person);
    }

    //delete existing record
    @DeleteMapping("/personlist/{id}")
    public Map<Long,String> deleteEmployeeRecord(@PathVariable(value = "id") long id) throws Exception{
        Person deletePerson = personDatabase.findById(id).orElseThrow(() -> new  Exception("Person by this SSN " + id + " not found in database"));

        personDatabase.delete(deletePerson);
        Map<Long, String> deleteResponse = new HashMap<>();
        deleteResponse.put(id, "Person by this SSN has been deleted ");
        return deleteResponse;
    }

}
