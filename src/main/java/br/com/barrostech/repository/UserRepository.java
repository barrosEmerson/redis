package br.com.barrostech.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.barrostech.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByNomeAndEmail(String nome, String email);

}
