package com.askanything.metadata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.askanything.metadata.entity.QuestionMetadata;

public interface QuestionMetadataRepository extends JpaRepository<QuestionMetadata, Integer> {

	List<QuestionMetadata> findByQuestionId(int id);
	
}

