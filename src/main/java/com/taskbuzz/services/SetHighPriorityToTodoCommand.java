package com.taskbuzz.services;

import com.taskbuzz.entities.Priority;
import com.taskbuzz.entities.Todo;

public class SetHighPriorityToTodoCommand implements PriorityCommand {
	
	private Todo todo;
	
	public SetHighPriorityToTodoCommand(Todo todo) {
		this.todo = todo;
	}

	@Override
	public void execute() {
		todo.setPriority(Priority.HIGH);
	}

}
