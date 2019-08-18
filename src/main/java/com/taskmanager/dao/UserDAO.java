package com.taskmanager.dao;

import java.util.List;

import com.taskmanager.model.User;

public interface UserDAO {
	
	public List<User> getUser();
	public User getUserById(int user_id);
	public User addUser(User user);
	public String deleteUserById(int user_id);
	public User updateUser(User user);

}
