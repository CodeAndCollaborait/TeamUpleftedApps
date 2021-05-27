package com.user.api.database;

import com.user.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDatabase extends JpaRepository<User, Long> {
}
