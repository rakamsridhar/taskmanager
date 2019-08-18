package com.taskmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taskmanager.model.User;

@Service
public interface UserService {
	public List<User> getUser();
	public User getUserById(int user_id);
	public User addUser(User user);
	public String deleteUserById(int user_id);
	public User updateUser(User user);
	
}
