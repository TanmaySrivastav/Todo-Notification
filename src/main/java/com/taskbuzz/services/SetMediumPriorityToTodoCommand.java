package com.taskbuzz.services;

import com.taskbuzz.entities.Priority;
import com.taskbuzz.entities.Todo;

public class SetMediumPriorityToTodoCommand implements PriorityCommand{

	private Todo todo;
	
	public SetMediumPriorityToTodoCommand(Todo todo) {
		this.todo = todo;
	}

	@Override
	public void execute() {
		todo.setPriority(Priority.MEDIUM);
	}
}
