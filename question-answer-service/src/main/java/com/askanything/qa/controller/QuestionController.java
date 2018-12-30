package com.askanything.qa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.askanything.qa.entity.Category;
import com.askanything.qa.entity.Question;
import com.askanything.qa.repository.QuestionRepository;

@RestController
public class QuestionController {

	@Autowired
	QuestionRepository questionRepository;
	
	@GetMapping(value="questions")
	public List<Question> getQuestion(){
		
		return questionRepository.findAll();
	}
	
	@GetMapping(value="questions/category/{id}")
	public List<Question> getQuestionByCatefory(@PathVariable int id){
		
		return questionRepository.findByCategory(new Category(id));
	}
	
	@PostMapping(value="questions")
	public Question saveQuestion(@RequestBody Question question){
		
		return questionRepository.save(question);
	}
}
