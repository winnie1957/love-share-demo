package net.codejava;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import net.codejava.dao.InstitutionDao;
import net.codejava.entity.Institution;
import net.codejava.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class InstitutionDaoTest {
	@Autowired
	private InstitutionDao repo;
	
	@Autowired
	private TestEntityManager entityManage;
	
	@Test
	public void testCreateInstitution() {
		Institution institution = new Institution();
		institution.setiName("dsfgergfdgr");
		institution.setiPassword("d12345");
		institution.setiInstitution("sdjasdfjewff");
		institution.setiEmail("df445@mail.com");
		
		Institution savedinstitution = repo.save(institution);
		Institution existinstitution = entityManage.find(Institution.class, savedinstitution.getiId());
		assertThat(existinstitution.getiEmail()).isEqualTo(institution.getiEmail());
	}
	
	

}
