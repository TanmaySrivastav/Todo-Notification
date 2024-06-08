package com.taskbuzz.services;

public class PriorityCommandInvoker {
	
	private PriorityCommand priorityCommand;
	
	public void setCommand(PriorityCommand priorityCommand) {
		this.priorityCommand = priorityCommand;
	}
	
	public void invokeCommand() {
		if(priorityCommand != null) {
			priorityCommand.execute();
		}
	}
}
