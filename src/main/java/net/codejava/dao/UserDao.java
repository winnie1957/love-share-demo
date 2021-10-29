package net.codejava.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.codejava.entity.User;

public interface UserDao extends JpaRepository<User, Long> {
	
//	@Query("SELECT u FROM user u WHERE u.user_email = ?1")
//	User findByUserEmail(String userEmail);
}
