package com.taskbuzz.services;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import com.taskbuzz.entities.Priority;
import com.taskbuzz.entities.Todo;

public class PriorityFactory {

	private final Map<String, Function<PriorityImpl, Priority>> priorityMap = new HashMap<>();
	
	public PriorityFactory() {
		//Create default Priorities with Decorators using Functional Interface
		//Input is a Todo and Output is a Priority
		priorityMap.put("HIGH", x -> new WithHighPriority(x).getPriority());
		priorityMap.put("MEDIUM", x -> new WithMediumPriority(x).getPriority());
		priorityMap.put("LOW", x -> new WithLowPriority(x).getPriority());
		priorityMap.put("EMERGENCY", x -> new WithEmergencyPriority(x).getPriority());
	}
	
	
	public Priority getPriorityFromDecorators(Todo todo, String priorityLevel) {
		if(priorityLevel != null) {
			return priorityMap.get(priorityLevel).apply(todo);
		}
		else return null;
		
	}

}
