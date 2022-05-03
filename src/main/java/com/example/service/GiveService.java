package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Give;
import com.example.model.Wish;
import com.example.repo.GiveRepository;

@Service
public class GiveService {

	@Autowired
	private GiveRepository giveRepo;

	public void save(Give give) {
		give.setgEnabled(true);
		giveRepo.save(give);
	}

	public void edit(Give give) {
		giveRepo.save(give);
	}
	
	public void cancel(Long id) {
		Give give = giveRepo.findById(id).get();
		give.setgEnabled(false);
		giveRepo.save(give);
	}
	
	public void delete(Long id) {
		giveRepo.deleteById(id);
	}
	
	public Give get(Long id) {
		return giveRepo.findById(id).get();
	}
	
	public List<Give> findAllGiveRecord(String uUsername) {
	    return giveRepo.findByCreatedBy(uUsername);
	}

	public List<Give> findAll() {
		return giveRepo.findAll();
	}
	
}
