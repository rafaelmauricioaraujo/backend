package br.dev.rafael.cyberspace.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.dev.rafael.cyberspace.model.User;

public class UserForm {
	
	@NotNull @NotEmpty @Length(max = 20)
	private String name;
	
	@NotNull @NotEmpty @Email
	private String email;
	
	@NotNull @NotEmpty @Length(max = 20)
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User converter() {
		return new User(name, email, password);
	}
	
	
}
