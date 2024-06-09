package com.taskbuzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskbuzz.entities.Todo;



@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
