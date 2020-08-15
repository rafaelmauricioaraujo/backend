package br.dev.rafael.cyberspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.rafael.cyberspace.model.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
	
	
}
