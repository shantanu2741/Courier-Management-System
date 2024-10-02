package com.cm.service;

import java.util.List;

import com.cm.entity.User;

public interface UserService {
	public User saveUser(User user);
	
	public List<User> getUsers(String role);
	
	public User getUserByEmail(String email);
	
	public boolean checkEmailAlreadyExist(String Email);
}
