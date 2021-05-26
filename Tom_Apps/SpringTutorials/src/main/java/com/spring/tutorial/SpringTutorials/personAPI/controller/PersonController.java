package com.spring.tutorial.SpringTutorials.personAPI.controller;

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
    public List<Person> getListOfEmployee(){
        return personDatabase.findAll();
    }

    @GetMapping("personlist/{personID}")
    public Optional<Person> getEmpById
            (@PathVariable(value = "personID") Integer personID){
        return personDatabase.findById(personID);
    }

    //only when we create new record
    @PostMapping("/personlist")
    public Person createNewPerson(@RequestBody Person person){
        return personDatabase.save(person);
    }

    @PutMapping("personlist/{id}")
    public Person updateExistingPerson(@RequestBody Person employee, @PathVariable(value = "personID")long personID) throws Exception{

        //Read and Update
        Person personDetails = personDatabase.findById((int) personID).orElseThrow(()-> new Exception("Emp by this ID" + personID + " not found in database"));

        //Update
        personDetails.setAddress(employee.getAddress());
        personDetails.setAge(employee.getAge());
        personDetails.setLastName(employee.getLastName());
        personDetails.setFirstName(employee.getFirstName());


        personDatabase.save(personDetails);
        return personDetails;
    }

    @DeleteMapping("personlist/{id}")
    public Map<Long, String> removePersonFromList(@PathVariable(value = "personID")long personID) throws Exception{
        Person personDetails = personDatabase.findById((int) personID).orElseThrow(()-> new Exception("Emp by this ID" + personID + " not found in database"));
        personDatabase.delete(personDetails);
        Map<Long, String> personDeleteResponse = new HashMap<>();
        personDeleteResponse.put(personID, "Emp by this ID has been deleted");
        return personDeleteResponse;
    }
}
