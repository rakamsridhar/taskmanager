package com.taskmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanager.dao.ProjectDAO;
import com.taskmanager.dao.UserDAO;
import com.taskmanager.model.Project;

@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectDAO projectDao;
	
	
	@Override
	public List<Project> getProject() {
		return projectDao.getProject();
	}

	@Override
	public Project getProjectById(int project_id) {
		return projectDao.getProjectById(project_id);
	}

	@Override
	public Project addProject(Project project) {
		return projectDao.addProject(project);
	}

	@Override
	public String deleteProjectById(int project_id) {
		return projectDao.deleteProjectById(project_id);
	}

	@Override
	public Project updateProject(Project project) {
		return projectDao.updateProject(project);
	}

	@Override
	public List<Project> sortProjects(String name) {
		return projectDao.sortProjects(name);		
	}

}
