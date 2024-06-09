package com.taskbuzz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.taskbuzz.entities.User;
import com.taskbuzz.request.AddToDoRequest;


@Service

public class AuthenticatedState implements UserTaskState {

	@Autowired
	private ToDoService todoservice;

	public AuthenticatedState(UserService userservice, ToDoService todoservice) {
		super();
		this.todoservice = todoservice;
	}
	
	@Override
	public User addTodo(@PathVariable Long userId, @RequestBody AddToDoRequest todoRequest) {

	return	todoservice.addToDoList(userId, todoRequest);
	}
	
	@Override
	public User deleteTodo(@PathVariable Long userId, @PathVariable Long todoId) {
		return todoservice.deleteToDo(userId, todoId);
	}
}