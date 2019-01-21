package com.askanything.qa.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.askanything.qa.entity.Category;
import com.askanything.qa.entity.Comment;
import com.askanything.qa.entity.Question;
import com.askanything.qa.entity.QuestionMetadata;
import com.askanything.qa.repository.QuestionRepository;

@RestController
@CrossOrigin
public class QuestionController {
 
	@Autowired
	QuestionRepository questionRepository;
	
	@GetMapping(value="questions")
	public List<Question> getQuestion(){
		
		String metadataURL = "http://localhost:8082/metadata/questions/";
		RestTemplate restTemplate = new RestTemplate();
		
		List<Question> questions= questionRepository.findAll();
		
		questions.stream().map(question -> {
			QuestionMetadata questionMetadata = restTemplate.getForObject(metadataURL+ question.getId(), QuestionMetadata.class);
			question.setQuestionMetadata(questionMetadata);
			return question;
		}).collect(Collectors.toList());
		
		String commentURL = "http://localhost:8082/comments/questions/";

		questions.stream().map(question -> {
			
			ResponseEntity<List<Comment>> response = restTemplate.exchange(
					  commentURL+question.getId(),
					  HttpMethod.GET,
					  null,
					  new ParameterizedTypeReference<List<Comment>>(){});
			List<Comment> comments = response.getBody();
			question.setComments(comments);
			return comments;
		}).collect(Collectors.toList());
		
		return questions;
	}
	
	@GetMapping(value="questions/categories/{id}")
	public List<Question> getQuestionByCategory(@PathVariable int id){

		List<Question> questions = questionRepository.findByCategory(new Category(id));
		
		questions.stream().map(question -> {
			QuestionMetadata questionMetadata = getMetadata(question.getId());
			question.setQuestionMetadata(questionMetadata);
			return question;
		}).collect(Collectors.toList());
		
		return questions;
	}
	
	@GetMapping(value="questions/{id}")
	public Question getQuestionInfo(@PathVariable int id){
		
		Optional<Question> questions = questionRepository.findById(id);
		
		Question question = questions.get();
		question.setComments(getComments(id));
		question.setQuestionMetadata(getMetadata(id));
		
		return question;
	}
	
	@PostMapping(value="questions")
	public Question saveQuestion(@RequestBody Question question){
		
		return questionRepository.save(question);
	}
	
	private QuestionMetadata getMetadata(int questionId) {
		
		String metadataURL = "http://localhost:8082/metadata/questions/";
		RestTemplate restTemplate = new RestTemplate();

		QuestionMetadata questionMetadata = restTemplate.getForObject(metadataURL+ questionId, QuestionMetadata.class);
		return questionMetadata;
	}

	private List<Comment> getComments(int questionId) {
		
		String commentURL = "http://localhost:8082/comments/questions/";
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<List<Comment>> response = restTemplate.exchange(
				  commentURL + questionId,
				  HttpMethod.GET,
				  null,
				  new ParameterizedTypeReference<List<Comment>>(){});
		List<Comment> comments = response.getBody();
		
		return comments;
	}
}
