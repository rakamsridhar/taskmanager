package com.taskmanager.model;

import java.sql.Date;

import org.springframework.stereotype.Component;
@Component
public class Project {
	private int project_id;	
	private String project;
	private Date start_date;
	private Date end_date;
	private int priority;
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
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
	public Project(int project_id, String project, Date start_date, Date end_date, int priority) {
		super();
		this.project_id = project_id;
		this.project = project;
		this.start_date = start_date;
		this.end_date = end_date;
		this.priority = priority;
	}
	
	public Project() {
		
	}
}
