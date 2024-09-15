package com.crudexample.basiccrudoperations.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudexample.basiccrudoperations.entity.User;
import com.crudexample.basiccrudoperations.repository.UserRepository;
import com.crudexample.basiccrudoperations.service.UserService;

@Service
public class UserServiceImplementation implements UserService {
	@Autowired
	private UserRepository userrepository;

	@Override
	public User createUser(User user) {
		return userrepository.save(user);

	}

	@Override
	public User getUserById(Long id) {
		return userrepository.findById(id).orElseThrow(null);

	}

	@Override
	public List<User> getAllUsers() {
		return userrepository.findAll();

	}

	@Override
	public User updateUser(Long id, User user) {

		User us = userrepository.save(user);
		us.setId(user.getId());
		us.setUserName(user.getUserName());
		us.setUserEmail(user.getUserEmail());

		return us;
	}

	@Override
	public void deleteById(Long id) {
		userrepository.deleteById(id);

	}

}
