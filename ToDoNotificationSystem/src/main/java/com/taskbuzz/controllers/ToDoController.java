package com.taskbuzz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskbuzz.entities.Todo;
import com.taskbuzz.entities.User;
import com.taskbuzz.request.AddToDoRequest;
import com.taskbuzz.request.UpdateToDoRequest;
import com.taskbuzz.services.ToDoService;
import com.taskbuzz.services.UpdateTodoCommand;
import com.taskbuzz.services.UserService;
import com.taskbuzz.services.Command;





@RestController
@RequestMapping("/todos")
public class ToDoController {

    @Autowired
	private ToDoService todoservice;
    
    @Autowired
	private UpdateToDoRequest updateToDoRequest;

	public ToDoController(UserService userservice, ToDoService todoservice, UpdateToDoRequest updateToDoRequest) {
		super();
		this.todoservice = todoservice;
		this.updateToDoRequest=updateToDoRequest;
	}

	@GetMapping("/{todoId}")
	public Todo getToDoById(@PathVariable Long todoId) {
		return todoservice.getToDoById(todoId);
	}

	@PostMapping("/{userId}/todos")
	public User addTodo(@PathVariable Long userId, @RequestBody AddToDoRequest todoRequest) {

	return	todoservice.addToDoList(userId, todoRequest);
	}

	@PostMapping("/todos/{todoId}")
	public Todo toggleTodoCompleted(@PathVariable Long todoId) {
	return	todoservice.toggleToDoCompleted(todoId);
	}

	@PutMapping("/todos/{todoId}")
	public void updateToDoById(@PathVariable Long todoId, @RequestBody UpdateToDoRequest updatetodorequest) {
		todoservice.updateToDoById(todoId,updatetodorequest);
	}

	@DeleteMapping("{userId}/todos/{todoId}")
	public void deleteTodo(@PathVariable Long userId, @PathVariable Long todoId) {
		todoservice.deleteToDo(userId, todoId);
	}
	
	@PutMapping("/update-todo/{todoId}")
    public void updateTodoFromCommandLine(@PathVariable Long todoId) {
        Command updateCommand = new UpdateTodoCommand(todoId, todoservice, updateToDoRequest);
        updateCommand.execute();
    }
}
