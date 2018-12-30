package com.askanything.qa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.askanything.qa.entity.Category;
import com.askanything.qa.repository.CategoryRepository;

@RestController
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping(value="categories")
	public List<Category> getCategory(){
		
		return categoryRepository.findAll();
	}
	
	@PostMapping(value="categories")
	public Category saveCategory(@RequestBody Category category){
		
		return categoryRepository.save(category);
	}
	
	@GetMapping(value="all")
	public String abc(){
		
		return "ram2";
	}
}
