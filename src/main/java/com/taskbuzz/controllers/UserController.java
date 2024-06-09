package com.taskbuzz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskbuzz.entities.User;
import com.taskbuzz.mediator.TodoMediator;
import com.taskbuzz.services.UserService;




@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/create-user")
	public User createUser(@RequestBody User user) {

		User createUser = userService.createUser(user);
		TodoMediator todoMediator = new TodoMediator();
		todoMediator.notifyUserCreated(createUser);
		return createUser;
	}

	@GetMapping("/{userId}")
	public User getUserById(@PathVariable Long userId) {
		return userService.getUserById(userId);
	}

    public void handleUserCreated(String email) {
	        System.out.println("UserController received notification: User created with email " + email);
	    }
}