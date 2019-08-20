package com.taskmanager.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.taskmanager.mapper.ProjectMapper;
import com.taskmanager.model.Project;


@Repository
public class ProjectDAOImpl implements ProjectDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;	
	
	@Override
	public List<Project> getProject() {
		String sql = "select * from taskmanager.project";
		List<Project> projects = jdbcTemplate.query(sql, new ProjectMapper());		
		return projects;
	}

	@Override
	public Project getProjectById(int project_id) {
		String sql = "select * from taskmanager.project where project_id =" + project_id;
		Project project = (Project)jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(Project.class));		
		return project;
	}

	@Override
	public Project addProject(Project project) {
		String sql = "insert into taskmanager.project values("+ project.getProject_id() + ",'" + project.getProject() + "','" +project.getStart_date() +"','"+ project.getEnd_date()+"'," +project.getPriority() +")";		
		jdbcTemplate.execute(sql);
		return project;
	}

	@Override
	public String deleteProjectById(int project_id) {
		String sql = "delete from taskmanager.project where project_id =" + project_id;
		jdbcTemplate.execute(sql);
		return "project deleted successfully";
	}

	@Override
	public Project updateProject(Project project) {
		String sql = "update taskmanager.project set project='" + project.getProject() + "', start_date='" + project.getStart_date() + "', end_date='" + project.getEnd_date() + "', priority=" + project.getPriority() + " where project_id=" + project.getProject_id();
		System.out.println("update SQL : " + sql);
		jdbcTemplate.execute(sql);
		return project;
	}

	@Override
	public List<Project> sortProjects(String name) {
		String sql = "select * from taskmanager.project order by " + name;
		List<Project> projects = jdbcTemplate.query(sql, new ProjectMapper());		
		return projects;
	}

}
