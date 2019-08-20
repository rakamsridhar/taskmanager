package com.taskmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taskmanager.model.Project;



@Service
public interface ProjectService {
	public List<Project> getProject();
	public Project getProjectById(int project_id);
	public Project addProject(Project project);
	public String deleteProjectById(int project_id);
	public Project updateProject(Project project);
	public List<Project> sortProjects(String name);

}
