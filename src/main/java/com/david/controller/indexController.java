package com.david.controller;

import org.hibernate.query.SortDirection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.david.domain.Board.Board;
import com.david.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class indexController {

	private final BoardService boardService;
	
	@GetMapping("/")
	public String index(Model model, 
						@PageableDefault(size = 5, sort = "id", direction = Direction.DESC) Pageable pageable,
						@RequestParam(required = false, defaultValue ="") String search ) {
        Page<Board> boards = boardService.findByTitleContainingOrContentContaining(search, search, pageable);
        int startPage = Math.max(1, boards.getPageable().getPageNumber() - 4);
        int endPage = Math.min(boards.getTotalPages(), boards.getPageable().getPageNumber() + 4);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("boards", boards);
        return "index";
    }
	
	
}
