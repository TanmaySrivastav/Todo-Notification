package com.taskbuzz.services;

public class TodoUpdateInvoker {
	private Command updateCommand;

    public void setUpdateCommand(Command updateCommand) {
        this.updateCommand = updateCommand;
    }

    public void executeUpdate() {
        updateCommand.execute();
    }
}
