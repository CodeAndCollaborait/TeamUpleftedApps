package com.spring.tutorial.SpringTutorials.personapi.controller;

import com.spring.tutorial.SpringTutorials.api.model.Employee;
import com.spring.tutorial.SpringTutorials.personapi.database.PersonDatabase;
import com.spring.tutorial.SpringTutorials.personapi.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController()
@RequestMapping("/api")

public class PersonController {
    @Autowired
    private PersonDatabase personDatabase;

    @GetMapping("/personlist")
    public List<Person> getListOfPerson(){
        return personDatabase.findAll();
    }

    @GetMapping("/personlist/{id}")
    public Optional<Person> getPersonById
            (@PathVariable(value = "id") long id){
        return personDatabase.findById(id);
    }

    //Only when creating a new record
    @PostMapping("/personlist")
    //@RequestBody- allows you to insert employee into data.sql
    public Person createNewPerson(@RequestBody Person person){
        return personDatabase.save(person);


    }

    @PutMapping("/personlist/{id}")
    public Person updateExistingPer(@RequestBody Person person, @PathVariable(value = "id") long id) throws Exception{
        //combination of read and update

        //Read
        Person personDetails = personDatabase.findById(id).orElseThrow(()->new Exception("Person by this ID" + id + "not found in database"));

        personDetails.setPersonName(person.getPersonName());
        personDetails.setOccupation(person.getOccupation());
        personDetails.setAge(person.getAge());
        personDetails.setSiblings(person.getSiblings());
        personDetails.setSign(person.getSign());

        personDatabase.save(personDetails);
        return personDetails;

    }
    @DeleteMapping("/personlist/{id}")
    public Map<Long,String> removeEmpFromList(@PathVariable(value = "id") long id) throws Exception{
        Person personDetails = personDatabase.findById(id).orElseThrow(()->new Exception("Emp by this ID" + id + "not found in database"));

        personDatabase.delete(personDetails);
        Map<Long,String> personDelete =new HashMap<>();
        personDelete.put(id, "Person by this ID has been deleted");
        return personDelete;

    }
}
