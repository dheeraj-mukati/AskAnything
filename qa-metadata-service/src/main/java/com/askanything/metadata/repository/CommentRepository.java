package com.askanything.metadata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.askanything.metadata.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

	//@Query("select c from comment c where c.question_id = ?1 and answer_id is null")
	List<Comment> findByQuestionId(int id);
	
	//@Query("select c from comment c where c.answer_id = ?1 and question_id is null")
	List<Comment> findByAnswerId(int id);

}
