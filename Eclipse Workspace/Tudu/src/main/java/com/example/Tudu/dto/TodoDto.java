package com.example.Tudu.dto;

import java.time.LocalDateTime;

public class TodoDto {
    private Long id;
    private String title;
    private String description;
    private boolean completed;
    private LocalDateTime createdAt;
	private LocalDateTime dueDate;
    private Long userId;
    
    
    
	public TodoDto() {
		super();
	}



	public TodoDto(Long id, String title, String description, boolean completed, LocalDateTime createdAt,
			LocalDateTime dueDate, Long userId) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.completed = completed;
		this.createdAt = createdAt;
		this.dueDate = dueDate;
		this.userId = userId;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public boolean isCompleted() {
		return completed;
	}



	public void setCompleted(boolean completed) {
		this.completed = completed;
	}



	public LocalDateTime getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}



	public LocalDateTime getDueDate() {
		return dueDate;
	}



	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}



	public Long getUserId() {
		return userId;
	}



	public void setUserId(Long userId) {
		this.userId = userId;
	}



	@Override
	public String toString() {
		return "TodoDto [id=" + id + ", title=" + title + ", description=" + description + ", completed=" + completed
				+ ", createdAt=" + createdAt + ", dueDate=" + dueDate + ", userId=" + userId + "]";
	}

}