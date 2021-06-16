package com.spring.tutorial.SpringTutorials.personapi.database;

import com.spring.tutorial.SpringTutorials.personapi.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDatabase extends JpaRepository<Person, Long> {
}
