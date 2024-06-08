package com.taskbuzz.services;


import com.taskbuzz.request.UpdateToDoRequest;

public class UpdateTodoCommand implements Command {
    
    private final Long todoId;
    private final ToDoService todoService;
    private final UpdateToDoRequest updateToDoRequest;

    public UpdateTodoCommand(Long todoId, ToDoService todoService,UpdateToDoRequest updateToDoRequest) {
        this.todoId = todoId;
        this.todoService = todoService;
        this.updateToDoRequest=updateToDoRequest;
        
    }

    @Override
    public void execute() {
       
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
