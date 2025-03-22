package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.Entity.User;
import java.lang.String;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

	User findByEmail(  String email);
	
}
