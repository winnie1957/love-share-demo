package com.example;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.example.model.Category;
import com.example.model.User;
import com.example.repo.CategoryRepository;
import com.example.repo.UserRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RepoTests {
	
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	UserRepository userRepo;
	@Autowired
	CategoryRepository categoryRepo;
	
	@Test
	public void testCreateUser() {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		String rawPassword = "12345";
//		String encoderPassword = encoder.encode(rawPassword);
//		User user = new User("user_1", encoderPassword, "user_1@mail.com", "user");
//      userRepo.save(user);

		User admin = new User("admin", encoder.encode("admin"), "admin@mail.com", "admin");
        userRepo.save(admin);
		User user1 = new User("winnie", encoder.encode("w12345"), "winnie@mail.com", "user");
        userRepo.save(user1);
		User user2 = new User("joy", encoder.encode("j12345"), "joy@mail.com", "user");
        userRepo.save(user2);
		User user3 = new User("mary", encoder.encode("m12345"), "mary@mail.com", "user");
        userRepo.save(user3);
        
//        User savedUser = userRepo.save(user);
//        User existUser = entityManager.find(User.class, savedUser.getuId());
	}

    
	@Test
	public void testCreateRoles() {
//		User user = new Role("user");
//		Role admin = new Role("admin");
//		Role customer = new Role("customer");
//		Role member = new Role("member");
//		Role superadmin = new Role("superadmin");
//
//		repo.saveAll(List.of(user, admin, member));
//		List<Role> listRoles = repo.findAll();
//		assertThat(listRoles.size()).isEqualTo(3);
		

		Category role_user = new Category("user", "role_category");
		Category role_admin = new Category("admin", "role_category");
		Category role_customer = new Category("customer", "role_category");
		Category role_member = new Category("member", "role_category");
		Category role_superadmin = new Category("superadmin", "role_category");

		categoryRepo.saveAll(List.of(role_user, role_admin, role_member));
		List<Category> listRoles = categoryRepo.findByCode("role_category");
		assertThat(listRoles.size()).isEqualTo(3);

	}
}
