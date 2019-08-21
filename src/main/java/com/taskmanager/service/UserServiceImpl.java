package com.taskmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanager.dao.UserDAO;
import com.taskmanager.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDao;

	@Override
	public List<User> getUser() {
		return userDao.getUser();		
	}

	@Override
	public User getUserById(int user_id) {
		return userDao.getUserById(user_id);
	}

	@Override
	public User addUser(User user) {
		return userDao.addUser(user);
	}

	@Override
	public String deleteUserById(int user_id) {
		return userDao.deleteUserById(user_id);
	}

	@Override
	public User updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public List<User> sortByName(String name) {		
		return userDao.sortByName(name);
	}

	@Override
	public List<User> searchByName(String name) {
		return userDao.searchByName(name);
	}

}
