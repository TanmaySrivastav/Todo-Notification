package com.todo.notification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.todo.notification.model.Todo;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

/**
 * @author Rishikesh
 *
 */
@Service
public class SmsService {
	// reading value from properties file
	@Value("${twilio.account.sid}")
	private String sid;

	@Value("${twilio.account.authtoken}")
	private String authToken;

	@Value("${twilio.account.fromphonenumber}")
	private String fromPhoneNumber;

	// send sms and check boolean flag to check if request is comin for complete
	// notification or reminder notification and create the body of the sms
	// acccordingly
	/**
	 * @param toNumber
	 * @param todoTaskList
	 * @param isCompleteNotification
	 */
	public void sendSms(String toNumber, List<Todo> todoTaskList, boolean isCompleteNotification) {
		try {
			for (Todo todoTask : todoTaskList) {
				String msgBody = null;
				if (isCompleteNotification) {
					msgBody = createCompleteNotifMsg(todoTask);

				} else {
					msgBody = createReminderNotifMsg(todoTask);
				}
				Twilio.init(sid, authToken);
				Message message = Message.creator(new com.twilio.type.PhoneNumber(toNumber),
						new com.twilio.type.PhoneNumber(fromPhoneNumber), msgBody).create();
				System.out.println(message.getSid());
			}
		} catch (Exception e) {
			System.out.println("Error occured while sending sms: " + e.getMessage());
		}
	}

	/**
	 * @param todoTask
	 * @return task details
	 */
	private String createCompleteNotifMsg(Todo todoTask) {
		if (null != todoTask.getTask())
			return "Your Task " + todoTask.getTask() + " has been completed.";
		return null;
	}

	private String createReminderNotifMsg(Todo todoTask) {
		if (null != todoTask.getTask() & null != todoTask.getDueDate())
			return "Your Task " + todoTask.getTask() + " is due by " + todoTask.getDueDate();
		return null;
	}

}
