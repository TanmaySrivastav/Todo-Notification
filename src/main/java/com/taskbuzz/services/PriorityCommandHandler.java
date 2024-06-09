package com.taskbuzz.services;

import java.util.HashMap;
import java.util.Map;

import com.taskbuzz.entities.Priority;
import com.taskbuzz.entities.Todo;

public class PriorityCommandHandler {

	// Map to store priority commands based on priority level
    private final Map<Priority, PriorityCommand> priorityCommandMap;

    public PriorityCommandHandler(Todo todo) {
        // Initialize the map with command instances
        priorityCommandMap = new HashMap<>();
        priorityCommandMap.put(Priority.HIGH, new SetHighPriorityToTodoCommand(todo));
        priorityCommandMap.put(Priority.MEDIUM, new SetMediumPriorityToTodoCommand(todo));
        priorityCommandMap.put(Priority.LOW, new SetLowPriorityToTodoCommand(todo));
        priorityCommandMap.put(Priority.EMERGENCY, new SetEmergencyPriorityToTodoCommand(todo));
    }

    // Method to set priority using the command pattern
    public void setPriorityWithCommand(Priority priorityLevel) {
        // Get the command based on the priority level from the map
        PriorityCommand priorityCommand = priorityCommandMap.get(priorityLevel);
        
        //Execute the Command to set the priority to task using Command Invoker
        PriorityCommandInvoker priorityCommandInvoker = new PriorityCommandInvoker();
        priorityCommandInvoker.setCommand(priorityCommand);
        priorityCommandInvoker.invokeCommand();
    }
}