package com.taskmanager.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.taskmanager.model.Task;

public class TaskMapper implements RowMapper<Task> {

	@Override
	public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
		Task task = new Task();
		task.setTask_id(rs.getInt("task_id"));
		task.setParent_id(rs.getInt("parent_id"));
		task.setTask(rs.getString("task"));
		task.setStart_date(rs.getDate("start_date"));
		task.setEnd_date(rs.getDate("end_date"));
		task.setPriority(rs.getInt("priority"));
		return task;
	}

}
