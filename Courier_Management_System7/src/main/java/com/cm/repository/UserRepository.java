package com.cm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cm.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	public boolean existsByEmail(String email);
	public User findByEmail(String email);
	public List<User> findByRole(String role);

}
