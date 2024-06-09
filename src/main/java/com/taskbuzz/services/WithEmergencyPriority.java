package com.taskbuzz.services;

import com.taskbuzz.entities.Priority;

public class WithEmergencyPriority extends PriorityDecorator {

	public WithEmergencyPriority(PriorityImpl priorityLevel) {
		super(priorityLevel);
	}

	//method Overriding replaces all previously decorated Priorities
	@Override
	public Priority getPriority() {
		return Priority.EMERGENCY;
	}
}
