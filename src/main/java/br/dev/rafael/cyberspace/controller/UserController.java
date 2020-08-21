package br.dev.rafael.cyberspace.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.dev.rafael.cyberspace.controller.dto.DetailUserDto;
import br.dev.rafael.cyberspace.controller.dto.UserDto;
import br.dev.rafael.cyberspace.controller.form.UpdateUserForm;
import br.dev.rafael.cyberspace.controller.form.UserForm;
import br.dev.rafael.cyberspace.model.User;
import br.dev.rafael.cyberspace.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	@Cacheable(value = "userList")
	public Page<UserDto> list(@RequestParam(required = false) String name,
			@PageableDefault(sort = "id", direction = Direction.ASC) Pageable pagination){
		
		Page<User> users;
		if(name == null) {
			users = userRepository.findAll(pagination);	
		}else {
			users = userRepository.findByName(name, pagination);
		}
		return UserDto.convert(users);
	}
	
	@PostMapping
	@CacheEvict(value = "userList", allEntries = true)
	public ResponseEntity<UserDto> create(@RequestBody @Valid UserForm form, UriComponentsBuilder uriBuilder) {
		User user = form.converter();
		userRepository.save(user);
		URI uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(new UserDto(user));
	}
	
	@GetMapping("/{id}")
	@CacheEvict(value = "userList", allEntries = true)
	public ResponseEntity<DetailUserDto> detail(@PathVariable Long id) {
		Optional<User> optional = userRepository.findById(id);
		if(optional.isPresent()) {
			return ResponseEntity.ok(new DetailUserDto(optional.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "userList", allEntries = true)
	public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody @Valid UpdateUserForm form){
		Optional<User> optional = userRepository.findById(id);
		if(optional.isPresent()) {
			User user = form.update(id, userRepository);
			return ResponseEntity.ok(new UserDto(user));			
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "userList", allEntries = true)
	public ResponseEntity<?> delete(@PathVariable Long id){
		Optional<User> optional = userRepository.findById(id);
		if(optional.isPresent()) {
			userRepository.deleteById(id);
			return ResponseEntity.ok().build();			
		}
		return ResponseEntity.notFound().build();
	}

}
