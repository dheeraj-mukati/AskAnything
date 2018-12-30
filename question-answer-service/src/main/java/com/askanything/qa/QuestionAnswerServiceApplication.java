package com.askanything.qa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.askanything.qa.repository.CategoryRepository;

@SpringBootApplication
@ComponentScan({"com.askanything.qa",
				"com.askanything.qa.controller",
				"com.askanything.qa.entity",
				"com.askanything.qa.repository"})
public class QuestionAnswerServiceApplication {

	@Autowired
	CategoryRepository categoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(QuestionAnswerServiceApplication.class, args);
	}
}

