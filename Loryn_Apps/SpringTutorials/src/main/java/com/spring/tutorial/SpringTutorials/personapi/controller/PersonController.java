package com.spring.tutorial.SpringTutorials.personapi.controller;

import com.spring.tutorial.SpringTutorials.personapi.database.PersonDatabase;
import com.spring.tutorial.SpringTutorials.personapi.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.List;
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
}
