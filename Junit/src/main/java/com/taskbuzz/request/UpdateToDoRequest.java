package com.taskbuzz.request;

import java.sql.Date;

import com.taskbuzz.entities.Priority;



public class UpdateToDoRequest {
	private String task;
	private Date dueDate;
	private Priority priority;

	public Date getDueDate() {
		return dueDate;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public UpdateToDoRequest(String Task, Date dueDate, Priority priority) {
		this.task = Task;
		this.dueDate = dueDate;
		this.priority = priority;
	}

	public UpdateToDoRequest() {
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

}
