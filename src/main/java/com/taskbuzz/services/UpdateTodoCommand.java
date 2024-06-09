package com.taskbuzz.services;

import java.util.Scanner;

import com.taskbuzz.entities.Priority;
import com.taskbuzz.request.UpdateToDoRequest;

public class UpdateTodoCommand implements Command {
    private final Scanner scanner;
    private final Long todoId;
    private final ToDoService todoService;

    public UpdateTodoCommand(Long todoId, ToDoService todoService) {
        this.todoId = todoId;
        this.todoService = todoService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        System.out.print("Enter todo ID to update: ");
        Long todoId = scanner.nextLong();
        scanner.nextLine(); // consume the newline character

        System.out.print("Enter updated task: ");
        String updatedTask = scanner.nextLine();

        System.out.print("Enter updated due date (yyyy-MM-dd): ");
        String updatedDueDateString = scanner.nextLine();
        java.sql.Date updatedDueDate = parseDate(updatedDueDateString);

        System.out.print("Enter updated priority (LOW, MEDIUM, HIGH): ");
        String updatedPriorityString = scanner.nextLine();
        Priority updatedPriority = Priority.valueOf(updatedPriorityString.toUpperCase());

        UpdateToDoRequest updateToDoRequest = new UpdateToDoRequest();
        updateToDoRequest.setTask(updatedTask);
        updateToDoRequest.setDueDate(updatedDueDate);
        updateToDoRequest.setPriority(updatedPriority);

        todoService.updateToDoById(todoId, updateToDoRequest);
    }

    private java.sql.Date parseDate(String dateString) {
        try {
            return java.sql.Date.valueOf(dateString);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            return null;
        }
    }
}
