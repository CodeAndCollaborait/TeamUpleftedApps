package com.spring.tutorial.SpringTutorials.api.database;

import com.spring.tutorial.SpringTutorials.api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpDatabase extends JpaRepository<Employee, Long> {

}
