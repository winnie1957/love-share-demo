package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Wish;


@Repository
public interface WishRepository extends JpaRepository<Wish, Long> {

	@Query("SELECT w FROM Wish w WHERE w.createdBy = ?1")
	public List<Wish> findByCreatedBy(String uUsername);
	
	@Query("SELECT w FROM Wish w WHERE w.wEnabled = true")
	public List<Wish> findAllEnabled();
		
//	@Override
//	default <S extends Wish> S save(S entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	

}
