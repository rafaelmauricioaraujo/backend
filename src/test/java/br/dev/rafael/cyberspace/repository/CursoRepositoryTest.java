package br.dev.rafael.cyberspace.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.dev.rafael.cyberspace.model.Curso;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CursoRepositoryTest {
	
	@Autowired
	private CursoRepository repository;
	
	@Test
	public void getCourseByName() {
		String cursoName = "HTML 5";
		Curso curso = repository.findByNome(cursoName);
		Assert.assertNotNull(curso);
		Assert.assertEquals(cursoName, curso.getNome());
		
	}

}
