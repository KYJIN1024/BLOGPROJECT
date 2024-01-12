package com.david.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.david.domain.user.User;
import com.david.domain.user.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Userservice {
	
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCrtBCryptPasswordEncoder;
	
	@Transactional
	public Long save(User user) {
		
		String hashPw = bCrtBCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(hashPw);
		return userRepository.save(user).getId();
		
	}
	
	@Transactional
	public Long update(User user) {
		User userEntity = userRepository.findById(user.getId()).orElseThrow(() -> 
						  new IllegalArgumentException("해당 회원이 없습니다. id="+ user.getId()));
		userEntity.update(bCrtBCryptPasswordEncoder.encode(user.getPassword()), user.getNickname());
		return userEntity.getId();
	}
	

}
