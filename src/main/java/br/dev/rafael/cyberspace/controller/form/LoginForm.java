package br.dev.rafael.cyberspace.controller.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginForm {
	
	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public UsernamePasswordAuthenticationToken converter() {	
		return new UsernamePasswordAuthenticationToken(email, password);
	}

}
