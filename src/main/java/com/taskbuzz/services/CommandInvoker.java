package com.taskbuzz.services;

public class CommandInvoker {
	
	private Command command;
	
	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void invokeCommand() {
		command.execute();
	}
}
