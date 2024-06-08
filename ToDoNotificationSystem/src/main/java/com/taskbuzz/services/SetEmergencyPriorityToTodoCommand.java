package com.taskbuzz.services;

import com.taskbuzz.entities.Priority;
import com.taskbuzz.entities.Todo;

public class SetEmergencyPriorityToTodoCommand implements PriorityCommand{

	private Todo todo;
	
	public SetEmergencyPriorityToTodoCommand(Todo todo) {
		this.todo = todo;
	}


	@Override
	public void execute() {
		todo.setPriority(Priority.EMERGENCY);
	}
}
