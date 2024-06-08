package com.taskbuzz.mediator;

import com.taskbuzz.controllers.UserController;
import com.taskbuzz.entities.User;

public class TodoMediator {

	public void notifyUserCreated(User user) {

		UserController usercontroller = new UserController();
		usercontroller.handleUserCreated(user.getEmailId());

	}
}
