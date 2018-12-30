package com.askanything.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	
	//insert into user(id,email,first_name,last_name,password) values(10001,'a@a.com','dheeraj','mukati','asas');

}

