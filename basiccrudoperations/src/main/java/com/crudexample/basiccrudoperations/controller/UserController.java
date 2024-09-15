package com.crudexample.basiccrudoperations.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudexample.basiccrudoperations.entity.User;
import com.crudexample.basiccrudoperations.repository.UserRepository;
import com.crudexample.basiccrudoperations.serviceimplementation.UserServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserServiceImplementation userServiceImpl;
	


	@PostMapping("/create")
	public User CreateUser(@RequestBody User user) {
		return userServiceImpl.createUser(user);

	}

	@GetMapping("{id}")
	public User getUserById(@PathVariable Long id) {

		return userServiceImpl.getUserById(id);

	}

	@GetMapping("/allUsers")
	public List<User> getAllUsers() {
		return userServiceImpl.getAllUsers();
	}

	@PutMapping("{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
		User updatedDetails = userServiceImpl.updateUser(id, user);
		return updatedDetails;
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable Long id) {
		userServiceImpl.deleteById(id);
	}

}
