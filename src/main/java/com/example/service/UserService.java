package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.model.Category;
import com.example.model.User;
import com.example.repo.CategoryRepository;
import com.example.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private CategoryRepository categoryRepo;
	
	
	public void saveDefaultRole(User user) {		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encoderPassword = encoder.encode(user.getuPassword());
		user.setuPassword(encoderPassword);
		user.setuRole("user");
		
		userRepo.save(user);	
	}
	
	public void save(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encoderPassword = encoder.encode(user.getuPassword());
		user.setuPassword(encoderPassword);
				
		userRepo.save(user);	
	}
	
	public List<User> listAll() {
		return userRepo.findAll();
	}
	
	public User get(Long id) {
		return userRepo.findById(id).get();
	}
	
	public List<Category> getRoles(){
		return categoryRepo.findByCode("role_category");
	}
	
	
}
