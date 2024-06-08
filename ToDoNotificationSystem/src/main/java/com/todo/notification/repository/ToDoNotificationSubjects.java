package com.todo.notification.repository;

import org.springframework.stereotype.Repository;

import com.todo.notification.model.User;

/**
 * @author Rishikesh
 *
 */
@Repository
public interface ToDoNotificationSubjects {

	 /**
	 * @param userObserver
	 */
	void addObserver(User userObserver);

	 /**
	 * @param user
	 */
	void removeObserver(User user);

	 void sendCompleteNotifEmailSms();
	 
	 void sendReminderNotifEmailSms();
	 
}
