package com.askanything.qa.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Question {

	@Id
	@GeneratedValue
	private int id;
	
	@OneToOne
	private Category category;
	
	private int userId;
	private String question;
	private String description;
	private Date createDt;
	
	@OneToMany(mappedBy="question")
	@JsonIgnore
	private List<Answer> answers;
	
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
	
}
