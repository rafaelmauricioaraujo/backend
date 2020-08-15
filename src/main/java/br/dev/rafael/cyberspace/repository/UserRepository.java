package br.dev.rafael.cyberspace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.rafael.cyberspace.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByName(String name);

}
