package com.askanything.userservice;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@PostMapping(value="/registration")
	public String registration(@Valid @RequestBody User user) {
		
		User dbUser = userRepository.findByEmail(user.getEmail());
		
		if(dbUser != null)
			return "User already exist!";
		
		dbUser = userRepository.save(user);
		if(dbUser != null)
			return String.valueOf(dbUser.getId());
		else
			return "user registration failed";
	}
	 
	@PostMapping(value="/login")
	public String login(@Valid @RequestBody User user) {
		
		User dbUser = userRepository.findByEmail(user.getEmail());
		
		if(dbUser == null)
			return "user not found!";
		else
			return "User logged in!";
		
	}
}
