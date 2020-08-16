package br.dev.rafael.cyberspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.rafael.cyberspace.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Curso findByNome(String nomeCurso);
	
}
