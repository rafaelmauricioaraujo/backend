package br.dev.rafael.cyberspace.controller.dto;


import org.springframework.data.domain.Page;

import br.dev.rafael.cyberspace.model.User;

public class UserDto {
	
	private Long id;
	private String name;
	private String email;
	
	public UserDto(User user) {
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

	public static Page<UserDto> convert(Page<User> users) {
		return users.map(UserDto::new);
	}
	
}
