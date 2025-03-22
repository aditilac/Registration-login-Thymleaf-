package com.example.demo.Services;

import com.example.demo.Entity.User;

public interface UserService {

	public boolean registerUser(User user);
	public User loginUser(String email,String password);
	
}
