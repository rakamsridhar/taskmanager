package com.taskmanager.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.taskmanager.model.Project;


public class ProjectMapper implements RowMapper<Project>{
	@Override
	public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
		Project project = new Project();		
		project.setProject_id(rs.getInt("project_id"));		
		project.setProject(rs.getString("project"));
		project.setStart_date(rs.getDate("start_date"));
		project.setEnd_date(rs.getDate("end_date"));
		project.setPriority(rs.getInt("priority"));		
		return project;
	}

}
