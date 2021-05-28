package com.user.api.Controller;


import com.user.api.Database.UserDatabase;
import com.user.api.exception.DataNotFoundException;
import com.user.api.exception.ErrorDetails;
import com.user.api.model.personList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class PersonController {

    //dependency injection
    @Autowired
    private UserDatabase userDatabase;

    @GetMapping("/personList")
    public List<personList> getpersonList(){
        return userDatabase.findAll();
    }

    @GetMapping("/personList/{id}")
    public Optional<personList> getEmpById
            (@PathVariable(value = "id") long id){
        return userDatabase.findById(id);
    }

    @PostMapping("/personList")
public personList createNewPerson(@RequestBody personList personList){
    return userDatabase.save(personList);


}
    @PutMapping("/personList/{id}")
    public personList updateExistingEmp(@RequestBody personList personList, @PathVariable(value = "id") long id) throws DataNotFoundException{
        //combination of read and update

        //Read
        personList PersonDetails = userDatabase.findById(id).orElseThrow(()->new DataNotFoundException(new ErrorDetails(new Date(), id + "NOT FOUND","GIVEN ID IS " + "NOT IN DATABASE")));

        PersonDetails.setEmail(personList.getEmail());
        PersonDetails.setName(personList.getName());
        PersonDetails.setPhone(personList.getPhone());
        PersonDetails.setUsername(personList.getUsername());
        PersonDetails.setWebsite(personList.getWebsite());
        PersonDetails.setZipCode(personList.getZipCode());

        userDatabase.save(PersonDetails);
        return PersonDetails;

    }
    @DeleteMapping("/personList/{id}")
    public Map<Long,String> removeEmpFromList(@PathVariable(value = "id") long id) throws Exception{
       personList userDetails = userDatabase.findById(id).orElseThrow(()->new Exception("Person by this ID" + id + "not found in database"));

        userDatabase.delete(userDetails);
        Map<Long,String> empDelete =new HashMap<>();
        empDelete.put(id, "Emp by this ID has been deleted");
        return empDelete;

    }

}
