package com.taskmanager.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import com.taskmanager.model.User;

public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();		
		user.setUser_id(rs.getInt("user_id"));
		user.setFirst_name(rs.getString("first_name"));
		user.setLast_name(rs.getString("last_name"));
		user.setEmployee_id(rs.getInt("employee_id"));
		user.setProject_id(rs.getInt("task_id"));
		user.setTask_id(rs.getInt("task_id"));		
		return user;
	}
}
