package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Give;
import com.example.model.Wish;

@Repository
public interface GiveRepository extends JpaRepository<Give, Long> {

	@Query("SELECT g FROM Give g WHERE g.createdBy = ?1")
	public List<Give> findByCreatedBy(String uUsername);
	
	@Query("SELECT g FROM Give g WHERE g.gEnabled = true")
	public List<Give> findAllEnabled();
}
