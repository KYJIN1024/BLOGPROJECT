package com.david.controller.api;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.david.config.auth.PrincipalDetail;
import com.david.domain.user.User;
import com.david.dto.board.BoardSaveRequestDto;
import com.david.dto.user.UserSaveRequestDto;
import com.david.service.BoardService;
import com.david.service.Userservice;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserApiController {

	private final Userservice userService;
	
	@PostMapping("/auth/api/v1/user")
	public Long save(@RequestBody UserSaveRequestDto userSaveRequestDto) {
		return userService.save(userSaveRequestDto.toEntity());
	}
	
	@PutMapping("/api/v1/user")
	public Long update(@RequestBody User user, @AuthenticationPrincipal PrincipalDetail principalDetail) {
	    return userService.update(user);
	}
	
	
	
	
}
