package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepo;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
private	UserRepo userRepo;
	@Override
	public boolean registerUser(User user) {
		// TODO Auto-generated method stub
		try {
			userRepo.save(user);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return  false;
		}
		
	}
	@Override
	public User loginUser(String email, String password) {
		// TODO Auto-generated method stub
	User validuser=	userRepo.findByEmail(email);
	if(validuser!=null && validuser.getPassword().equals(password)) {
		return validuser;
	}
		return null;
	}

}
