package br.dev.rafael.cyberspace.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.dev.rafael.cyberspace.model.User;
import br.dev.rafael.cyberspace.repository.UserRepository;

public class UpdateUserForm {
	
	@NotNull @NotEmpty @Length(min = 5)
	private String name;
	
	@NotNull @NotEmpty @Email
	private String email;
	
	@NotNull @NotEmpty @Length(max = 10)
	private String password;

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public User update(Long id, UserRepository userRepository) {
		User user = userRepository.getOne(id);
		user.setName(this.name);
		user.setEmail(this.email);
		user.setPassword(this.password);
		return user;
	}
	
}
