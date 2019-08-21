package com.taskmanager.dao;

import java.util.List;

import com.taskmanager.model.Project;

public interface ProjectDAO {
	public List<Project> getProject();
	public Project getProjectById(int project_id);
	public Project addProject(Project project);
	public String deleteProjectById(int project_id);
	public Project updateProject(Project project);
	public List<Project> sortProjects(String name);
	public List<Project> searchByName(String name);
}
