package br.dev.rafael.cyberspace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.rafael.cyberspace.controller.dto.UserDto;
import br.dev.rafael.cyberspace.model.User;
import br.dev.rafael.cyberspace.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/user")
	public List<UserDto> list(String name){
		List<User> users;
		if(name == null) {
			users = userRepository.findAll();			
		}else {
			users = userRepository.findByName(name);
		}
		return UserDto.convert(users);
	}

}
