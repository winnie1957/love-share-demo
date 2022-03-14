package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Wish;

@Repository
public interface WishRepository extends JpaRepository<Wish, Long> {

}
