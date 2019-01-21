package com.askanything.metadata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.askanything.metadata.entity.AnswerMetadata;
import com.askanything.metadata.repository.AnswerMetadataRepository;

@RestController
public class AnswerMetadataController {

	@Autowired
	private AnswerMetadataRepository answerMetadataRepository;
	
	@GetMapping(value="metadata/answers/{id}")
	public AnswerMetadata getMetadata(@PathVariable int id){
		
		List<AnswerMetadata> answerMetadatas = answerMetadataRepository.findByAnswerId(id);
		
		if(answerMetadatas !=null && answerMetadatas.size() > 0)
			return answerMetadatas.get(0);
		else 
			return null;
	}	
	
	@PostMapping(value="metadata/answers")
	public AnswerMetadata getQuestionsComment(@RequestBody AnswerMetadata answerMetadata){
		
		return answerMetadataRepository.save(answerMetadata);
	}
}
