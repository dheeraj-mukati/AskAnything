package com.askanything.qa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.askanything.qa.entity.Answer;
import com.askanything.qa.entity.Question;

public interface AnswerRepository extends JpaRepository<Answer, Integer>{

	List<Answer> findByQuestion(Question question);
}
