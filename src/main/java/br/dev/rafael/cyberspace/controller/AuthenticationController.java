package br.dev.rafael.cyberspace.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.rafael.cyberspace.config.security.TokenService;
import br.dev.rafael.cyberspace.controller.dto.TokenDto;
import br.dev.rafael.cyberspace.controller.form.LoginForm;

@RestController
@RequestMapping("/login")
@Profile(value = {"prod", "test"})
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenDto> login(@RequestBody @Valid LoginForm form){
		UsernamePasswordAuthenticationToken loginData = form.converter();
		try {
			Authentication authentication = authManager.authenticate(loginData);
			authManager.authenticate(loginData);
			String token = tokenService.generateToken(authentication);
			return ResponseEntity.ok(new TokenDto(token, "Bearer"));
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
			
		}
	}
	
}
