package com.cm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.cm.repository.UserRepository;
import com.cm.entity.User;

@Component
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	public UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user=userRepo.findByEmail(username);
		
		if(user==null)
		{
			throw new UsernameNotFoundException("User not found");
		}
		else
		{
			return new CustomUser(user);
		}
	}

}
