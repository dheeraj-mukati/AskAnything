package com.askanything.metadata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.askanything.metadata.entity.AnswerMetadata;

public interface AnswerMetadataRepository extends JpaRepository<AnswerMetadata, Integer> {

	List<AnswerMetadata> findByAnswerId(int id);
	
}

