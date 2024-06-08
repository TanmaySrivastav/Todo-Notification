package com.todo.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.notification.model.Todo;

/**
 * @author Rishikesh
 *
 */
@Repository
public interface TodoDataRepo extends JpaRepository<Todo, Long> {

}
