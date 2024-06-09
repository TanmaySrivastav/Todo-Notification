package com.taskbuzz.services;

import com.taskbuzz.entities.Priority;
import com.taskbuzz.entities.Todo;

public class SetLowPriorityToTodoCommand implements PriorityCommand{

	private Todo todo;
	
	public SetLowPriorityToTodoCommand(Todo todo) {
		this.todo = todo;
	}

	@Override
	public void execute() {
		todo.setPriority(Priority.LOW);
	}

}
