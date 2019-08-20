package com.taskmanager.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.taskmanager.mapper.TaskMapper;
import com.taskmanager.mapper.UserMapper;
import com.taskmanager.model.Task;
import com.taskmanager.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<User> getUser() {
		String sql = "select * from taskmanager.users";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());		
		return users;
	}

	@Override
	public User getUserById(int user_id) {
		String sql = "select * from taskmanager.users where user_id =" + user_id;
		User user = (User)jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(User.class));		
		return user;
	}

	@Override
	public User addUser(User user) {
		String sql = "insert into taskmanager.users values("+ user.getUser_id() + ",'" + user.getFirst_name() + "','" + user.getLast_name() + "'," +user.getEmployee_id() +","+ user.getProject_id()+"," +user.getTask_id() +")";
		//System.out.println("SQL String --------------> " + sql);
		jdbcTemplate.execute(sql);
		return user;
	}

	@Override
	public String deleteUserById(int user_id) {
		String sql = "delete from taskmanager.users where user_id =" + user_id;
		jdbcTemplate.execute(sql);
		return "user deleted successfully";
	}

	@Override
	public User updateUser(User user) {
		String sql = "update taskmanager.users set first_name='" + user.getFirst_name() + "', last_name='" + user.getLast_name() + "', employee_id='" + user.getEmployee_id() + "', project_id='" + user.getProject_id() + "', task_id=" + user.getTask_id() + " where user_id=" + user.getUser_id();
		System.out.println("update SQL : " + sql);
		jdbcTemplate.execute(sql);
		return user;
	}

}
