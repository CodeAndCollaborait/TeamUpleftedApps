package com.user.api.Database;
import com.user.api.model.personList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDatabase extends JpaRepository<personList,Long> {
}
