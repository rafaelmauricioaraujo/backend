package br.dev.rafael.cyberspace.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.dev.rafael.cyberspace.controller.dto.DetailUserDto;
import br.dev.rafael.cyberspace.controller.dto.UserDto;
import br.dev.rafael.cyberspace.controller.form.UserForm;
import br.dev.rafael.cyberspace.model.User;
import br.dev.rafael.cyberspace.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<UserDto> list(String name){
		List<User> users;
		if(name == null) {
			users = userRepository.findAll();	
		}else {
			users = userRepository.findByName(name);
		}
		return UserDto.convert(users);
	}
	
	@PostMapping
	public ResponseEntity<UserDto> cadastrar(@RequestBody @Valid UserForm form, UriComponentsBuilder uriBuilder) {
		User user = form.converter();
		userRepository.save(user);
		URI uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(new UserDto(user));
	}
	
	@GetMapping("/{id}")
	public DetailUserDto detail(@PathVariable Long id) {
		User user = userRepository.getOne(id);
		return new DetailUserDto(user);
	}

}
