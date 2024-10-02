package com.cm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cm.entity.User;
import com.cm.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	public UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public User saveUser(User user)
	{
		
		String password=passwordEncoder.encode(user.getPassword());
		user.setPassword(password);
		user.setRole("ROLE_USER");
		User use=userRepo.save(user);
		return use;
	}
	
	@Override
	public List<User> getUsers(String role) {
		return userRepo.findByRole(role);
	}

	public boolean checkEmailAlreadyExist(String email)
	{
		return userRepo.existsByEmail(email);
	}
	
	@Override
	public User getUserByEmail(String email) {
		return userRepo.findByEmail(email);
	}
}
