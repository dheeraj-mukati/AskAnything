package com.askanything.qa.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private int id;

	private String category;
	
	@OneToMany(mappedBy="category")
	@JsonIgnore
	private List<Question> question;

	public Category() {
		
	}
	
	public Category(int id) {
		this.id=id;
	}

	public Category(int id, String category) {
		this.id=id;
		this.category=category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
