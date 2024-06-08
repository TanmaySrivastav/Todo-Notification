package com.taskbuzz.services;

import com.taskbuzz.request.UpdateToDoRequest;

public class TodoUpdateClient {
	public static void main(String[] args) {
		// Client Code
		final Long todoId = 1L;
		final ToDoService todoService = new ToDoService();
		final UpdateToDoRequest updateToDoRequest = new UpdateToDoRequest();

		// Create the command object
		Command updateCommand = new UpdateTodoCommand(todoId, todoService, updateToDoRequest);

		// Create the invoker
		TodoUpdateInvoker invoker = new TodoUpdateInvoker();
		invoker.setUpdateCommand(updateCommand);

		// Invoke the command
		invoker.executeUpdate();
	}
}
