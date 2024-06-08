package com.todo.notification.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Todo {

	@Id
	private Long todoId;
	private Long userId;
	private String task;
	private Boolean completed = Boolean.FALSE;
	private Date dueDate;

	@Enumerated(EnumType.STRING)
	private Priority priority;
	private String category;
	private boolean subscribed;

	public Todo(Long todoId, Long userId, String task, Boolean completed, Date dueDate, Priority priority,
			String category, boolean subscribed) {
		super();
		this.todoId = todoId;
		this.userId = userId;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Todo [todoId=" + todoId + ", userId=" + userId + ", task=" + task + ", completed=" + completed
				+ ", dueDate=" + dueDate + ", priority=" + priority + ", category=" + category + ", subscribed="
				+ subscribed + "]";
	}

}
