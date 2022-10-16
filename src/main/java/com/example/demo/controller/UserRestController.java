package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.service.UserDataException;
import com.example.demo.service.UserService;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
@RequestMapping(path = "/users")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	//CRUD
	
	@PostMapping(path = "user/create")
	public void createUser(@RequestBody User user) {
		userService.createUser(user);
	}
	
	@PostMapping(path = "multiUsers/create")
	public void createUsers(@RequestBody  Iterable<User> users) {
		userService.createUsers(users);
	}
	
	@GetMapping(path = "id/{id}")
	public User getUserById(@PathVariable("id") Integer id) throws UserDataException {
		return userService.findUserById(id);
	}
	
	@GetMapping(path = "/allusers")
	public Iterable<User> getAllUsers() {
		return userService.findAllUsers();
	}
	
	@PutMapping(path = "id/{id}/newAge/{newAge}")
	public void updateUserAgeById(@PathVariable("id") Integer userId,@PathVariable("newAge") Integer newAge) {
		userService.updateUserAgeById(userId, newAge);
	}
	@PutMapping(path = "/allusers/{id}")
	public void updateUserById(@PathVariable("id") Integer userId,@RequestBody User user) {
		userService.updateUserById(userId, user);
	}
	
	@DeleteMapping(path = "delete/id/{id}")
	public void deleteUserById(@PathVariable("id") Integer userId) {
		userService.deleteUserById(userId);
	}
}