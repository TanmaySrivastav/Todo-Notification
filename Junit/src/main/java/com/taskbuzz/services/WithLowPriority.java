package com.taskbuzz.services;

import com.taskbuzz.entities.Priority;

public class WithLowPriority extends PriorityDecorator{

	public WithLowPriority(PriorityImpl priorityLevel) {
		super(priorityLevel);
	}

	//method Overriding replaces all previously decorated Priorities
	@Override
	public Priority getPriority() {
		return Priority.LOW;
	}
	
}

