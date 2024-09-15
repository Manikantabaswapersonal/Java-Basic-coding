package com.crudexample.basiccrudoperations.service;

import java.util.List;

import com.crudexample.basiccrudoperations.entity.User;

public interface UserService {
	
	User createUser(User user);
	User getUserById(Long id);
	List<User> getAllUsers();
	User updateUser(Long id, User user);
	void deleteById(Long id);
	
	

}
