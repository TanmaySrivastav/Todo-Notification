package com.todo.notification.repository;

import org.springframework.stereotype.Repository;

import com.todo.notification.model.User;

/**
 * @author Rishikesh
 *
 */
@Repository
public interface ToDoNotificationObserver {

	/**
	 * @param user
	 */
	void updateCompleteNotificationMail(User user);

	/**
	 * @param user
	 */
	void updateReminderNotificationMail(User user);
}
