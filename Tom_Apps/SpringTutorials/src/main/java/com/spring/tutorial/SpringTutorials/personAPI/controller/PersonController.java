package com.spring.tutorial.SpringTutorials.personAPI.controller;

import com.spring.tutorial.SpringTutorials.personAPI.database.PersonDatabase;
import com.spring.tutorial.SpringTutorials.personAPI.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personapi")
public class PersonController {
    @Autowired
    private PersonDatabase personDatabase;

    @GetMapping("/personlist")
    public List<Person> getListOfEmployee(){
        return personDatabase.findAll();
    }

    @GetMapping("personlist/{personID}")
    public Optional<Person> getEmpById
            (@PathVariable(value = "personID") Integer personID){
        return personDatabase.findById(personID);
    }
}
