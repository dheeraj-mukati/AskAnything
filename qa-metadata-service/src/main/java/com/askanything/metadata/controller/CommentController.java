package com.askanything.metadata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.askanything.metadata.entity.Comment;
import com.askanything.metadata.repository.CommentRepository;

@RestController
public class CommentController {

	@Autowired
	private CommentRepository commentRepository;
	
	@GetMapping(value="comments/questions/{id}")
	public List<Comment> getQuestionsComment(@PathVariable int id){
		
		return commentRepository.findByQuestionId(id);
	}
	
	@GetMapping(value="comments/answers/{id}")
	public List<Comment> getAnswersComment(@PathVariable int id){
		
		return commentRepository.findByAnswerId(id);
	}
	
	@PostMapping(value="comments")
	public Comment saveComment(@RequestBody Comment comment){
		
		return commentRepository.save(comment);
	}
}
