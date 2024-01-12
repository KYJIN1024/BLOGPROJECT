package com.david.blogproject.domain.user;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.david.domain.user.Role;
import com.david.domain.user.User;
import com.david.domain.user.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserRepositoryTest {
	
	 @Autowired
	 UserRepository userRepository;

	 @AfterEach
	 public void cleanup() {
		 userRepository.deleteAll();
	 }
	 
	 @Test
	 public void registertest() {
		 
		 //given
		 String username = "test";
		 String nickname = "babo";
		 
		 userRepository.save(User.builder()
				 .username(username)
				 .password("1234")
				 .email("test@naver.com")
				 .nickname(nickname)
				 .role(Role.USER)
				 .build());
	 		
	 
	 	//when
	 	List<User> userList = userRepository.findAll();
		 
	 	 // Assert (단언)
        User user = userList.get(0);

        assertThat(user.getUsername()).isEqualTo(username);
        assertThat(user.getNickname()).isEqualTo(nickname);

	 }
}
	 
	 
	 
	 

