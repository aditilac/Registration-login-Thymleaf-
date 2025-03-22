package com.example.demo.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
import com.example.demo.Services.UserService;

import reactor.netty.http.server.HttpServerRequest;
@Controller

public class Mycontroller {
	@Autowired
	private UserService userservice;
	
	@GetMapping("/regpage")
	public String openregpage( Model model) {
		model.addAttribute("user",new User());
		return "register";
		
	}
	@PostMapping("/regform")
	public String submitreg(@ModelAttribute("user") User user,Model model) {
		
	boolean status=	userservice.registerUser(user);
	if(status) {
		model.addAttribute("successmsg", "user add successfully");
		
	}else {
		model.addAttribute("errormsg", "user not register due to some error");
	}
		return "register";
	}
	
	@GetMapping("/loginpage")
public String openLogin(Model model) {
		model.addAttribute("user" ,new User());
	return "login";
	
}
	@PostMapping("/loginform")
	public String submitloginform( @ModelAttribute("user") User user, Model model) {
	User validuser=	userservice.loginUser(user.getEmail(), user.getPassword());
		
	if( validuser!=null ) {
	model.addAttribute("modelname", validuser.getName());
		return "profile";
	}
	else {
		model.addAttribute("errormsg" ,"email id and password didnt match");
		return "login";
	}
	
	}
	@GetMapping("/Logout")
	public String logout(HttpServletRequest request){
		HttpSession session=  request.getSession(false);
	
		if(session!=null) {
			session.invalidate();
		}
		
		
		return "redirect:/loginpage";
		
	}
	
}
