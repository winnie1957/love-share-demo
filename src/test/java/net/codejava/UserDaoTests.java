package net.codejava;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import net.codejava.dao.UserDao;
import net.codejava.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserDaoTests{
	
	@Autowired
	private UserDao repo;
	@Autowired
	private TestEntityManager entityManage;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setUserEmail("bbb@mail.com");
		user.setUserPassword("b12345");
		user.setUserName("big boss");
		user.setAdmin(false);
		
		User savedUser = repo.save(user);
		User existUser = entityManage.find(User.class, savedUser.getUserId());
		assertThat(existUser.getUserEmail()).isEqualTo(user.getUserEmail());
	}
	
//	@Test
//	public void testFindUserByEmail() {
//		String email = "nam@mail.com";
//		User user = repo.findByUserEmail(email);
//		assertThat(user).isNotNull();
//	} 
	
}
