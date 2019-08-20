package com.taskmanager.dao;

import java.util.List;

import com.taskmanager.model.Task;

public interface TaskDAO {
	public List<Task> getTask();
	public Task getTaskById(int task_id);
	public Task addTask(Task task);
	public String deleteTaskById(int task_id);
	public Task updateTask(Task task);
}
