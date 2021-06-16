package com.user.api.controller;

import com.user.api.database.UserDatabase;
import com.user.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class UserController {

    @Autowired
    private UserDatabase userDatabase;

    @GetMapping("/user")
    public List<User> getUserList(){
        return userDatabase.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable(name = "id") Long id){
        return userDatabase.findById(id);
    }

    @PostMapping("/user")
    public User addNewUser(@RequestBody User user){
        return userDatabase.save(user);
    }

    @PutMapping("/user/{id}")
    public User updateUserRecord(@RequestBody User user, @PathVariable(name = "id") Long id) throws Exception {
        User updateUserRecord = userDatabase.findById(id).orElseThrow(() -> new Exception("person by this ID " + id + " not found in database"));

        updateUserRecord.setAddress(user.getAddress());
        updateUserRecord.setCompany(user.getCompany());
        updateUserRecord.setUserName(user.getUserName());
        updateUserRecord.setEmail(user.getEmail());
        updateUserRecord.setName(user.getName());
        updateUserRecord.setPhoneNumber(user.getPhoneNumber());
        updateUserRecord.setWebsite(user.getWebsite());
        updateUserRecord.setZip(user.getZip());
        return updateUserRecord;

    }

    @DeleteMapping("/user/{id}")
    public Map<Long,String> deleteUserRecord(@PathVariable(name = "id") Long id) throws Exception {
        User deleteUserRecord = userDatabase.findById(id).orElseThrow(() -> new Exception("person by this ID " + id + " not found in database"));
        userDatabase.delete(deleteUserRecord);
        Map<Long, String> userRecord = new HashMap<>();
        userRecord.put(id, "Emp by this ID has been deleted ");
        return userRecord;
    }
}
