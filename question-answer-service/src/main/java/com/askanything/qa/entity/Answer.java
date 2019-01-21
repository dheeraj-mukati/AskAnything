package com.askanything.qa.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Answer {

	@Id
	@GeneratedValue
	private int id;
	
	private int userId;

	private String answer;
	
	@OneToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Question question;
	
	@Transient
	private List<Comment> comments;
	
	@Transient
	private AnswerMetadata answerMetadata;
	
	private Date createDt = new Date();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public AnswerMetadata getAnswerMetadata() {
		return answerMetadata;
	}

	public void setAnswerMetadata(AnswerMetadata answerMetadata) {
		this.answerMetadata = answerMetadata;
	}

}
