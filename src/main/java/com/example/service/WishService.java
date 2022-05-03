package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Wish;
import com.example.repo.WishRepository;

@Service
public class WishService {

	@Autowired
	private WishRepository wishRepo;
	
	public void save(Wish wish) {
		wish.setwEnabled(true);
		wishRepo.save(wish);
	}

	public void edit(Wish wish) {
		wishRepo.save(wish);
	}

	public void cancel(Long id) {
		Wish wish = wishRepo.findById(id).get();
		wish.setwEnabled(false);
		wishRepo.save(wish);
	}
	
	public void delete(Long id) {
		wishRepo.deleteById(id);
	}
	
	public Wish get(Long id) {
		return wishRepo.findById(id).get();
	}

	public List<Wish> findAllWishRecord(String uUsername) {
	    return wishRepo.findByCreatedBy(uUsername);
	}
		
	public List<Wish> findAllEnabled() {
		return wishRepo.findAllEnabled();
	}
	
	public List<Wish> findAll() {
		return wishRepo.findAll();
	}
	
}
