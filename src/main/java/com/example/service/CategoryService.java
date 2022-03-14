package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Category;
import com.example.repo.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	public void saveWithCode(Category category, String code) {
		category.setcCode(code);
		categoryRepo.save(category);
	}

	public List<Category> listAll(){
		return categoryRepo.findAll();
	}
	
	public List<Category> listByCode(String code){
		return categoryRepo.findByCode(code);
	}
	
}
