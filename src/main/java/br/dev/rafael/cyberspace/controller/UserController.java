package br.dev.rafael.cyberspace.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.rafael.cyberspace.controller.dto.UserDto;
import br.dev.rafael.cyberspace.model.User;

@RestController
public class UserController {
	
	@RequestMapping("/user")
	public List<UserDto> list(){
		User user = new User();
		user.setName("Rafael");
		user.setId(1L);
		user.setEmail("rafael@rafael.com");
		user.setPassword("123");
		
		return UserDto.convert(Arrays.asList(user, user, user));
	}

}
