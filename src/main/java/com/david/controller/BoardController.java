package com.david.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.david.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardController {
	
	private final BoardService boardService;

	@GetMapping("/board/save")
	public String save() {
		return "layout/board/board-save";
		
	}
	
	@GetMapping("/board/[id]")
	public String detail(@PathVariable Long id, Model model) {
		model.addAttribute("board", boardService.detail(id));
		boardService.updateCount(id);
		return "layout/board/board-detail";
	}
	
	@DeleteMapping("/api/v1/board/{id]")
	public Long deleteById(@PathVariable Long id) {
		boardService.deleteById(id);
		return id;
	}
	
	@GetMapping("/board/{id}/update")
	public String update(@PathVariable Long id, Model model) {
		model.addAttribute("board", boardService.detail(id));
		return "layout/board/board-update";
	}
	
	
	
	
}
