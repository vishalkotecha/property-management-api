package com.example.propertymanager.dao;

import com.example.propertymanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Long> {

    Optional<User> findUserByApiKey(String apiKey);
}
