package br.com.barrostech.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.barrostech.exception.ObjectNotFoundException;
import br.com.barrostech.model.User;
import br.com.barrostech.repository.UserRepository;
import br.com.barrostech.service.exception.UserAlreadyExistException;

@Service
public class UserService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserRepository repository;
	
	@Cacheable(cacheNames = "User",key="#root.method.name")
	public List<User> findAll(){
		return repository.findAll();
	}
	
	@Cacheable(cacheNames = "User",key="#id")
	public User findById(Long id) {
		Optional<User>user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	@CacheEvict(cacheNames="User",allEntries=true)
	public User create(User user) {
		Optional<User> userExist = repository.findByNomeAndEmail(user.getNome(), user.getEmail());
		if(userExist.isPresent()) {
			throw new UserAlreadyExistException(HttpStatus.BAD_REQUEST);
		}
		
		return repository.save(user);
	}
	
}
