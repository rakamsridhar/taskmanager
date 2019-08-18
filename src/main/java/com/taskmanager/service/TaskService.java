package com.taskmanager.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.taskmanager.model.Task;

@Service
public interface TaskService {
	public List<Task> getTask();
	public Task getTaskById(int task_id);
	public Task addTask(Task task);
	public String deleteTaskById(int task_id);
	public Task updateTask(Task task);
	
}
