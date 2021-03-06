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
public class Question {

	@Id
	@GeneratedValue
	private int id;
	
	@OneToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Category category;
	
	private int userId;
	private String question;
	private String description;
	private Date createDt = new Date();
	
	@Transient
	private List<Comment> comments;
	
	@Transient
	private QuestionMetadata questionMetadata;
	
	//default constructor
	public Question() {
		
	}
	
	public Question(int id) {
		this.id=id;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
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

	public QuestionMetadata getQuestionMetadata() {
		return questionMetadata;
	}

	public void setQuestionMetadata(QuestionMetadata questionMetadata) {
		this.questionMetadata = questionMetadata;
	}

}
