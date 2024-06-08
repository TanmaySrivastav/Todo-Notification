package com.todo.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.todo.notification.exception.ResourceNotFoundException;
import com.todo.notification.repository.ToDoNotificationSubjects;

/**
 * @author Rishikesh
 *
 */
@RestController
@RequestMapping("/notification")
public class TodoNotificationController {

	
	@Autowired
	private ToDoNotificationSubjects toDoSubject;

	// sending complete todo task notification mail & sms
	/**
	 * @return ResponseEntity<String>
	 */
	@PostMapping("/completenotification")
	public ResponseEntity<String> completeNotificationMail() {
		try {
			toDoSubject.sendCompleteNotifEmailSms();
			return ResponseEntity.ok("To-Do Tasks Notification mails & sms sent to users");
		} catch (ResourceNotFoundException exc) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Url Not Found", exc);
		}

	}

	/**
	 * @return ResponseEntity<String>
	 */
	// sending reminder todo task notification mail & sms
	@PostMapping("/remindernotification")
	public ResponseEntity<String> reminderNotificationMail() {
		try {
			toDoSubject.sendReminderNotifEmailSms();
			return ResponseEntity.ok("To-Do Tasks Reminder mails & sms sent to users");
		} catch (ResourceNotFoundException exc) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Url Not Found", exc);
		}
	}

}
