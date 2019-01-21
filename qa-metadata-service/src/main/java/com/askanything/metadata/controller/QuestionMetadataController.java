package com.askanything.metadata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.askanything.metadata.entity.QuestionMetadata;
import com.askanything.metadata.repository.QuestionMetadataRepository;

@RestController
public class QuestionMetadataController {

	@Autowired
	private QuestionMetadataRepository questionMetadataRepository;
	
	@GetMapping(value="metadata/questions/{id}")
	public QuestionMetadata getMetadata(@PathVariable int id){
		
		List<QuestionMetadata> questionMetadatas = questionMetadataRepository.findByQuestionId(id);
		
		if(questionMetadatas !=null && questionMetadatas.size() > 0)
			return questionMetadatas.get(0);
		else 
			return null;
	}
	
	@PostMapping(value="metadata/questions")
	public QuestionMetadata getQuestionsComment(@RequestBody QuestionMetadata questionMetadata){
		
		return questionMetadataRepository.save(questionMetadata);
	}
}
