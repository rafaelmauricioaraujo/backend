package br.dev.rafael.cyberspace.repository;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.dev.rafael.cyberspace.model.User;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private TestEntityManager entityManager;
	

	@Test
	public void getUserByEmail() {
		String email = "rafael@rafael.com";
		
		User user = new User();
		user.setEmail(email);
		entityManager.persist(user);
		
		Optional<User> result = repository.findByEmail(email);
		
		Assert.assertNotNull(result);
		Assert.assertEquals(email, result.get().getEmail());
	}
	
	@Test
	public void DoNotGetUserByEmail() {
		String email = "emailqualquer";
		Optional<User> result = repository.findByEmail(email);
		Assert.assertFalse(result.isPresent());
	}

}
