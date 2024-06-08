package com.taskbuzz.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.taskbuzz.entities.Priority;
import com.taskbuzz.entities.Role;
import com.taskbuzz.entities.Todo;
import com.taskbuzz.entities.User;
import com.taskbuzz.repository.TodoRepository;
import com.taskbuzz.repository.UserRepository;
import com.taskbuzz.request.AddToDoRequest;
import com.taskbuzz.request.UpdateToDoRequest;
import com.taskbuzz.services.ToDoService;
import com.taskbuzz.services.UserService;

@SpringBootTest
class ToDoServiceTest {

	@MockBean
	private UserRepository userRepository;

	@MockBean
	private TodoRepository todoRepository;

	@MockBean
	private UserService userService;

	@Autowired
	private ToDoService toDoService;

	@BeforeEach
	void setUp() {
	}

	@Test
	void testGetToDoById() {

		Long todoId = 1L;
		Todo expectedTodo = new Todo(1L, "Task 1", false, new Date(6789999), Priority.LOW, "Work",true);

		when(todoRepository.findById(todoId)).thenReturn(Optional.of(expectedTodo));

		Todo actualTodo = toDoService.getToDoById(todoId);

		assertEquals(expectedTodo, actualTodo);
	}

	@Test
	void testGetToDoByIdThrowsNoSuchElementException() {

		Long todoId = 1L;
		when(todoRepository.findById(todoId)).thenReturn(Optional.empty());

		assertThrows(NoSuchElementException.class, () -> toDoService.getToDoById(todoId));
	}

	@Test
	void testAddToDoList() {

		Long userId = 1L;
		AddToDoRequest todoRequest = new AddToDoRequest("Task", new Date(6789999), Priority.HIGH, "Category",true);

		User user = new User(1L, "John", "john@example.com", "password123", new ArrayList<>(), Role.USER,"8976543217");
		Todo todo = new Todo(1L, "Task 1", false, new Date(6789999), Priority.LOW, "Work",true);
		when(userService.getUserById(userId)).thenReturn(user);
		when(todoRepository.save(any())).thenReturn(todo);
		when(userRepository.save(any())).thenReturn(user);

		User actualUser = toDoService.addToDoList(userId, todoRequest);

		assertEquals(user, actualUser);
		assertEquals(1, user.getTodoList().size());
	}

	@Test
	void testToggleToDoCompleted() {

		Long todoId = 1L;
		Todo todo = new Todo();
		when(todoRepository.findById(todoId)).thenReturn(Optional.of(todo));
		when(todoRepository.save(todo)).thenReturn(todo);

		Todo toggledTodo = toDoService.toggleToDoCompleted(todoId);

		assertTrue(toggledTodo.getCompleted());
	}

	@Test
	void testDeleteToDo() {
		Long userId = 1L;
		Long todoId = 1L;
		User user = new User();
		Todo todo = new Todo();
		user.getTodoList().add(todo);

		when(userService.getUserById(userId)).thenReturn(user);
		when(todoRepository.findById(todoId)).thenReturn(Optional.of(todo));

		User actualUser = toDoService.deleteToDo(userId, todoId);

		assertEquals(user, actualUser);
		assertEquals(0, user.getTodoList().size());
	}

	@Test
	void testUpdateToDoById() {

		Long todoId = 1L;
		UpdateToDoRequest updateRequest = new UpdateToDoRequest("NewTask", new Date(6789999), Priority.MEDIUM);

		Todo todo = new Todo();
		todo.setTask("OldTask");
		todo.setDueDate(new Date(6789999));
		todo.setPriority(Priority.MEDIUM);

		when(todoRepository.findById(todoId)).thenReturn(Optional.of(todo));
		when(todoRepository.save(todo)).thenReturn(todo);

		toDoService.updateToDoById(todoId, updateRequest);

		assertEquals("NewTask", todo.getTask());
		assertEquals(new Date(6789999), todo.getDueDate());
		assertEquals(Priority.MEDIUM, todo.getPriority());
	}
	
	@Test
	void testUpdateToDoPriorityLevelById() {
		Long todoId = 1L;
		UpdateToDoRequest updateRequest = new UpdateToDoRequest();
		updateRequest.setPriority(Priority.HIGH);
		
		
		Todo todo = new Todo();
		todo.setTask("OldTask");
		todo.setDueDate(new Date(6789999));
		todo.setPriority(Priority.MEDIUM);
		
		when(todoRepository.findById(todoId)).thenReturn(Optional.of(todo));
		when(todoRepository.save(todo)).thenReturn(todo);

		toDoService.updateToDoById(todoId, updateRequest);
		
		assertEquals(Priority.HIGH, todo.getPriority());
		
		
		updateRequest.setPriority(Priority.EMERGENCY);
		toDoService.updateToDoById(todoId, updateRequest);
		
		assertEquals(Priority.EMERGENCY, todo.getPriority());
		
		updateRequest.setPriority(Priority.LOW);
		toDoService.updateToDoById(todoId, updateRequest);
		
		assertEquals(Priority.LOW, todo.getPriority());
	}
}