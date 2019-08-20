package com.taskmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanager.dao.TaskDAO;
import com.taskmanager.model.Task;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDAO taskDao;
	
	
	@Override
	public List<Task> getTask() {		
		return taskDao.getTask();
	}

	@Override
	public Task getTaskById(int task_id) {		
		return taskDao.getTaskById(task_id);
	}

	@Override
	public Task addTask(Task task) {		
		return taskDao.addTask(task);
		
	}

	@Override
	public String deleteTaskById(int task_id) {		
		return taskDao.deleteTaskById(task_id);
	}

	@Override
	public Task updateTask(Task task) {		
		return taskDao.updateTask(task);
	}


}
