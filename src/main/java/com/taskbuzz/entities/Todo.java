package com.taskbuzz.entities;

import java.sql.Date;

import com.taskbuzz.services.PriorityImpl;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity

public class Todo extends PriorityImpl{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long todoId;
	private String task;
	private Boolean completed = Boolean.FALSE;
	private Date dueDate;
	private boolean subscribed;

	@Enumerated(EnumType.STRING)
	private Priority priority;
	private String category;

	public Todo(Long toDoId, String task, Boolean completed, Date dueDate, Priority priority, String category,boolean subscribed){
		super();
		todoId = toDoId;
		this.task = task;
		this.completed = completed;
		this.dueDate = dueDate;
		this.priority = priority;
		this.category = category;
		this.subscribed = subscribed;
	}

	public Todo() {
	}

	public Long getTodoId() {
		return todoId;
	}

	public void setTodoId(Long todoId) {
		this.todoId = todoId;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public boolean isSubscribed() {
		return subscribed;
	}

	public void setSubscribed(boolean subscribed) {
		this.subscribed = subscribed;
	}

}