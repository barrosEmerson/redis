package br.com.barrostech.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.barrostech.model.User;
import br.com.barrostech.service.UserService;

@RestController
@RequestMapping("/")
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User>users = service.findAll();
		
		return ResponseEntity.ok().body(users);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User user = service.findById(id);
		
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping
	public ResponseEntity<User>create(@RequestBody User user){
		service.create(user);
		
		return ResponseEntity.ok().body(user);
	}
	
}
