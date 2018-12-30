package com.askanything.qa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.askanything.qa.repository.CategoryRepository;

@SpringBootApplication
public class QuestionAnswerServiceApplication {

	@Autowired
	CategoryRepository categoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(QuestionAnswerServiceApplication.class, args);
	}
}

