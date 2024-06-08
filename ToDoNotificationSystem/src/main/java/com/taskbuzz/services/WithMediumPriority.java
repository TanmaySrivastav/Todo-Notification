package com.taskbuzz.services;

import com.taskbuzz.entities.Priority;

public class WithMediumPriority extends PriorityDecorator{

	public WithMediumPriority(PriorityImpl priorityLevel) {
		super(priorityLevel);
	}

	//method Overriding replaces all previously decorated Priorities
	@Override
	public Priority getPriority() {
		return Priority.MEDIUM;
	}
	
}