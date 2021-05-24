package com.spring.tutorial.SpringTutorials.personAPI.database;

import com.spring.tutorial.SpringTutorials.personAPI.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDatabase extends JpaRepository<Person, Integer> {
}
