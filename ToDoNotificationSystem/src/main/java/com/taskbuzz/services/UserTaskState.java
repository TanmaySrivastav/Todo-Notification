package com.taskbuzz.services;

import com.taskbuzz.entities.User;
import com.taskbuzz.request.AddToDoRequest;

public interface UserTaskState {
  
	User addTodo(Long userId,AddToDoRequest todoRequest);
	User deleteTodo(Long userId, Long todoId);
}
