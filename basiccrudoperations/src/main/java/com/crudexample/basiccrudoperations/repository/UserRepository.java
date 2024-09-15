package com.crudexample.basiccrudoperations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudexample.basiccrudoperations.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	

}
