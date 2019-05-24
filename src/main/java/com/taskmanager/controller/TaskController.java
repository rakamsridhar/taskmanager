package com.taskmanager.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.model.Task;
import com.taskmanager.service.TaskService;

import io.swagger.annotations.Api;

@Api(value="TMS", description="Task Management System")
@RestController
@CrossOrigin
@RequestMapping("/taskmanager")
public class TaskController {
	

	@Autowired
	private TaskService taskService;
	
	
	@GetMapping(value="/all", produces= {"application/xml","application/json"})	
	public ResponseEntity<List<Task>> getAllTasks() {
			return ResponseEntity.ok().body(taskService.getTask());
	}
	
	@GetMapping("/{task_id}")	
	public ResponseEntity<Task> getTaskById(@PathVariable int task_id) {
		return ResponseEntity.ok(taskService.getTaskById(task_id));
		 
	}
	
	@PostMapping(value="/add", consumes= {"application/xml","application/json"}, produces= {"application/xml","application/json"})	
	public ResponseEntity addTask(@RequestBody Task task) {
		return ResponseEntity.ok(taskService.addTask(task));		
	}
	
	@DeleteMapping("/delete/{task_id}")	
	public String deleteTaskById(@PathVariable String task_id) {
		return taskService.deleteTaskById(Integer.parseInt(task_id));
	}
	
	
	@PutMapping(value="/update", consumes= {"application/xml","application/json"}, produces= {"application/xml","application/json"})	
	public String updateTask(@RequestBody Task task) {
		return taskService.updateTask(task);
	}
}
