package com.david.domain.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);
		
	}

