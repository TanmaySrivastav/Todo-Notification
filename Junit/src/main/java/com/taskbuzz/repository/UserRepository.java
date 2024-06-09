package com.taskbuzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskbuzz.entities.User;

import java.util.Optional;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
public Optional<User> findByEmailId (String email);
}
