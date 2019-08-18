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

import com.taskmanager.model.Project;
import com.taskmanager.service.ProjectService;

import io.swagger.annotations.Api;

@Api(value="PMS", description="Project Management System")
@RestController
@CrossOrigin
@RequestMapping("/projects")
public class ProjectController {
	

	@Autowired
	private ProjectService projectService;
	
	
	@GetMapping(value="/all", produces= {"application/json"})	
	public ResponseEntity<List<Project>> getAllProjects() {
			return ResponseEntity.ok().body(projectService.getProject());
	}
	
	@GetMapping("/{project_id}")	
	public ResponseEntity<Project> getProjectById(@PathVariable int project_id) {		
		return ResponseEntity.ok(projectService.getProjectById(project_id));
		 
	}
	
	@PostMapping(value="/add", consumes= {"application/json"}, produces= {"application/json"})	
	public ResponseEntity<Project> addProject(@RequestBody Project project) {
		System.out.println("executing add project-------------------->");
		return ResponseEntity.ok(projectService.addProject(project));		
	}
	
	@DeleteMapping("/delete/{project_id}")	
	public String deleteProjectById(@PathVariable String project_id) {
		return projectService.deleteProjectById(Integer.parseInt(project_id));
	}
	
	
	@PutMapping(value="/update", consumes= {"application/json"}, produces= {"application/json"})	
	public ResponseEntity<Project> updateProject(@RequestBody Project project) {
		System.out.println("executing Update project-------------------->");
		return ResponseEntity.ok(projectService.updateProject(project));
	}

}
