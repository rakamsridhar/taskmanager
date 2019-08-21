package com.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.taskmanager.model.User;

import com.taskmanager.service.UserService;

import io.swagger.annotations.Api;

@Api(value="UMS", description="User Management System")
@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
	

	@Autowired
	private UserService userService;
	
	
	@GetMapping(value="/all", produces= {"application/json"})	
	public ResponseEntity<List<User>> getAllUsers() {
			return ResponseEntity.ok().body(userService.getUser());
	}
	
	@GetMapping(value="/sortByName", produces= {"application/json"})	
	public ResponseEntity<List<User>> sortUsersByName(@RequestParam String name) {
			return ResponseEntity.ok().body(userService.sortByName(name));
	}
	
	@GetMapping("/{user_id}")	
	public ResponseEntity<User> getUserById(@PathVariable int user_id) {		
		return ResponseEntity.ok(userService.getUserById(user_id));
		 
	}
	
	@PostMapping(value="/add", consumes= {"application/json"}, produces= {"application/json"})	
	public ResponseEntity<User> addUser(@RequestBody User user) {
		System.out.println("executing add user-------------------->");
		return ResponseEntity.ok(userService.addUser(user));		
	}
	
	@DeleteMapping("/delete/{user_id}")	
	public String deleteUserById(@PathVariable String user_id) {
		return userService.deleteUserById(Integer.parseInt(user_id));
	}
	
	
	@PutMapping(value="/update", consumes= {"application/json"}, produces= {"application/json"})	
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		System.out.println("executing Update user-------------------->");
		return ResponseEntity.ok(userService.updateUser(user));
	}
	
	@GetMapping(value="/searchByName", produces= {"application/json"})	
	public ResponseEntity<List<User>> searchByName(@RequestParam String name) {
			return ResponseEntity.ok().body(userService.searchByName(name));
	}
}

