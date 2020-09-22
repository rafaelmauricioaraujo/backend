package br.dev.rafael.cyberspace.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.dev.rafael.cyberspace.model.Curso;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class CursoRepositoryTest {
	
	@Autowired
	private CursoRepository repository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void getCourseByName() {
		String cursoName = "HTML 5";
		
		Curso html5 = new Curso();
		html5.setNome(cursoName);
		entityManager.persist(html5);
		
		Curso curso = repository.findByNome(cursoName);
		Assert.assertNotNull(curso);
		Assert.assertEquals(cursoName, curso.getNome());
		
	}
	
	@Test
	public void dontGetCourseByName() {
		String courseName = "JPA";
		Curso course = repository.findByNome(courseName);
		Assert.assertNull(course);
	}

}
