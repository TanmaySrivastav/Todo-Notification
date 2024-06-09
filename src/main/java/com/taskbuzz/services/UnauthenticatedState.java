package com.taskbuzz.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.taskbuzz.entities.User;
import com.taskbuzz.exception.UnauthorizedAccessException;
import com.taskbuzz.request.AddToDoRequest;

@Service

public class UnauthenticatedState implements UserTaskState {

	@Override
	public User addTodo(@PathVariable Long userId, @RequestBody AddToDoRequest todoRequest) {

		throw new UnauthorizedAccessException(
				"Access Denied !! Full authentication is required to access this resource");
	}

	@Override
	public User deleteTodo(@PathVariable Long userId, @PathVariable Long todoId) {
		throw new UnauthorizedAccessException(
				"Access Denied !! Full authentication is required to access this resource");
	}
}