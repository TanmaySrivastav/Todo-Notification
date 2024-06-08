package com.taskbuzz.services;

import com.taskbuzz.entities.Priority;

public class WithHighPriority extends PriorityDecorator{

	public WithHighPriority(PriorityImpl priorityLevel) {
		super(priorityLevel);
	}

	//method Overriding replaces all previously decorated Priorities
	@Override
	public Priority getPriority() {
		return Priority.HIGH;
	}
	
}
