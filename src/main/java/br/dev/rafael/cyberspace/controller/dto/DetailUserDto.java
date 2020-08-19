package br.dev.rafael.cyberspace.controller.dto;

import br.dev.rafael.cyberspace.model.User;

public class DetailUserDto {
	
	private Long id;
	private String name;
	private String email;
	
	public DetailUserDto(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
	
}
