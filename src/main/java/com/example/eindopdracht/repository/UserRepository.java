package com.example.eindopdracht.repository;

import com.example.eindopdracht.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
