package com.david.controller.api;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.david.config.auth.PrincipalDetail;
import com.david.dto.board.BoardSaveRequestDto;
import com.david.dto.board.BoardUpdateRequestDto;
import com.david.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BoardApiController {
	
	private final BoardService boardService;

	
	@PostMapping("/api/v1/board")
	public Long save(@RequestBody BoardSaveRequestDto boardSaveRequestDto, @AuthenticationPrincipal PrincipalDetail principalDetail) {
		return boardService.save(boardSaveRequestDto, principalDetail.getUser());
	}
	
	@PutMapping("/api/v1/board/{id}")
	public Long update(@PathVariable Long id, @RequestBody BoardUpdateRequestDto boardUpdateRequestDto) {
		return boardService.update(id, boardUpdateRequestDto);
	}
	
	
}