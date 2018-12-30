package com.askanything.qa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.askanything.qa.entity.Category;
import com.askanything.qa.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>{

	List<Question> findByCategory(Category category);
}
