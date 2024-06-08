package com.todo.notification.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.todo.notification.model.User;

/**
 * @author Rishikesh
 *
 */
@Repository
public interface UserDataRepo extends JpaRepository<User, Long> {

	/**
	 * @return List<User>
	 */
	@Query("select u from User u, Todo t where t.completed = true and t.subscribed = true and u.userId = t.userId")
	List<User> findCompletedTask();

	/**
	 * @return List<User>
	 */
	@Query("SELECT u\r\n" + "FROM User u, Todo t\r\n" + "WHERE t.subscribed = true and \r\n"
			+ "u.userId = t.userId and\r\n" + "DATEDIFF(t.dueDate,CURDATE()) <= 2")
	List<User> getTaskDueDateDetails();

}
