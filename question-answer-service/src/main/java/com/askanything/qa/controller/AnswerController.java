package com.askanything.qa.controller;

import java.util.List;
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

import com.askanything.qa.entity.Answer;
import com.askanything.qa.entity.AnswerMetadata;
import com.askanything.qa.entity.Comment;
import com.askanything.qa.entity.Question;
import com.askanything.qa.repository.AnswerRepository;

@RestController
@CrossOrigin
public class AnswerController {

	@Autowired
	AnswerRepository answerRepository;
	
	@GetMapping(value="answers/questions/{id}")
	public List<Answer> getAnswer(@PathVariable int id){
		
		List<Answer> answers= answerRepository.findByQuestion(new Question(id));
		
		answers.stream().map(answer -> {
			
			AnswerMetadata answerMetadata = getMetadata(answer.getId());
			answer.setAnswerMetadata(answerMetadata);
			answer.setComments(getComments(answer.getId()));
			
			return answer;
		}).collect(Collectors.toList());
		
		return answers;
	}
		
	@PostMapping(value="answers")
	public Answer saveAnswer(@RequestBody Answer answer){
		
		return answerRepository.save(answer);
	}
	
	private AnswerMetadata getMetadata(int answerId) {
		
		String metadataURL = "http://localhost:8082/metadata/answers/";
		RestTemplate restTemplate = new RestTemplate();

		AnswerMetadata answerMetadata = restTemplate.getForObject(metadataURL+ answerId, AnswerMetadata.class);
		return answerMetadata;
	}

	private List<Comment> getComments(int answerId) {
		
		String commentURL = "http://localhost:8082/comments/answers/";
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<List<Comment>> response = restTemplate.exchange(
				  commentURL + answerId,
				  HttpMethod.GET,
				  null,
				  new ParameterizedTypeReference<List<Comment>>(){});
		List<Comment> comments = response.getBody();
		
		return comments;
	}

}
