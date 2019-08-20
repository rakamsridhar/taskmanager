package com.taskmanager.model;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Component
public class Task {
	private int task_id;
	private int parent_id;
	private String task;
	private Date start_date;
	private Date end_date;
	private int priority;
	private int project_id;
	private String status = "PENDING";
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTask_id() {
		return task_id;
	}
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Task(int task_id, int parent_id, String task, Date start_date, Date end_date, int priority, int project_id,
			String status) {
		super();
		this.task_id = task_id;
		this.parent_id = parent_id;
		this.task = task;
		this.start_date = start_date;
		this.end_date = end_date;
		this.priority = priority;
		this.project_id = project_id;
		this.status = status;
	}
	public Task() {

	}
}
