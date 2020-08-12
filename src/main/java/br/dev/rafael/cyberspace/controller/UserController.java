package br.dev.rafael.cyberspace.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.rafael.cyberspace.model.User;

@RestController
public class UserController {
	
	@RequestMapping("/user")
	public List<User> list(){
		User user = new User();
		return Arrays.asList(user, user, user);
	}

}
