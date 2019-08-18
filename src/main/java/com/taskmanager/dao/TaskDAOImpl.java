package com.taskmanager.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.taskmanager.mapper.TaskMapper;
import com.taskmanager.model.Task;

@Repository
public class TaskDAOImpl implements TaskDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Task> getTask() {
		String sql = "select * from taskmanager.task";
		List<Task> tasks = jdbcTemplate.query(sql, new TaskMapper());		
		return tasks;
	}

	@Override
	public Task getTaskById(int task_id) {
		String sql = "select * from taskmanager.task where task_id =" + task_id;
		Task task = (Task)jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(Task.class));		
		return task;
	}

	@Override
	public Task addTask(Task task) {
		String sql = "insert into taskmanager.task values("+ task.getTask_id() + "," + task.getParent_id() + ",'" + task.getTask() + "','" +task.getStart_date() +"','"+ task.getEnd_date()+"'," +task.getPriority() +")";
		//System.out.println("SQL String --------------> " + sql);
		jdbcTemplate.execute(sql);
		return task;
	}

	@Override
	public String deleteTaskById(int task_id) {		
		String sql = "delete from taskmanager.task where task_id =" + task_id;
		jdbcTemplate.execute(sql);
		return "task deleted successfully";
	}

	@Override
	public Task updateTask(Task task) {
		String sql = "update taskmanager.task set parent_id=" + task.getParent_id() +", task='" + task.getTask() + "', start_date='" + task.getStart_date() + "', end_date='" + task.getEnd_date() + "', priority=" + task.getPriority() + " where task_id=" + task.getTask_id();
		System.out.println("update SQL : " + sql);
		jdbcTemplate.execute(sql);
		return task;
	}

}
